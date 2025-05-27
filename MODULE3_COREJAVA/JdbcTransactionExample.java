import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// --- Account POJO (Optional, but good practice for representing entities) ---
class Account {
    private int id;
    private String name;
    private double balance;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; } // Needed for update

    @Override
    public String toString() {
        return "Account [ID=" + id + ", Name='" + name + "', Balance=" + String.format("%.2f", balance) + "]";
    }
}

// --- AccountDAO (Data Access Object) ---
class AccountDAO {
    private static final String JDBC_URL = "jdbc:sqlite:javatest.db";

    public AccountDAO() {
        // Ensure the accounts table exists
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "balance REAL NOT NULL)";
            stmt.execute(createTableSQL);
            // System.out.println("Ensured 'accounts' table exists.");
        } catch (SQLException e) {
            System.err.println("Error initializing database/table: " + e.getMessage());
        }
    }

    /**
     * Retrieves an account by its ID.
     * @param accountId The ID of the account.
     * @return Account object if found, null otherwise.
     */
    public Account getAccountById(int accountId) {
        String SQL = "SELECT id, name, balance FROM accounts WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, accountId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Account(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving account: " + e.getMessage());
        }
        return null;
    }

    /**
     * Updates the balance of a specific account.
     * This method is package-private as it's intended to be used within a transaction.
     * @param conn The active database connection (part of the transaction).
     * @param accountId The ID of the account to update.
     * @param amount The amount to add (positive) or subtract (negative) from the balance.
     * @return The number of rows affected.
     * @throws SQLException If a database access error occurs.
     */
    private int updateAccountBalance(Connection conn, int accountId, double amount) throws SQLException {
        String SQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            return pstmt.executeUpdate();
        }
    }

    /**
     * Simulates a money transfer between two accounts using JDBC transactions.
     * Ensures atomicity: either both debit and credit succeed, or neither do.
     *
     * @param fromAccountId The ID of the account to debit.
     * @param toAccountId The ID of the account to credit.
     * @param amount The amount to transfer.
     * @return true if the transfer was successful, false otherwise.
     */
    public boolean transferMoney(int fromAccountId, int toAccountId, double amount) {
        if (amount <= 0) {
            System.out.println("Transfer failed: Amount must be positive.");
            return false;
        }

        Connection conn = null; // Declare connection outside try-with-resources for finally block access
        try {
            conn = DriverManager.getConnection(JDBC_URL);
            // 1. Disable auto-commit to start a transaction
            conn.setAutoCommit(false);
            System.out.println("Transaction started (auto-commit disabled).");

            // Check if fromAccount exists and has sufficient balance
            Account fromAccount = getAccountById(fromAccountId);
            if (fromAccount == null) {
                System.out.println("Transfer failed: 'From' account (ID " + fromAccountId + ") not found.");
                conn.rollback(); // Rollback immediately if account not found
                return false;
            }
            if (fromAccount.getBalance() < amount) {
                System.out.println("Transfer failed: Insufficient funds in account " + fromAccountId + ". Balance: " + fromAccount.getBalance());
                conn.rollback(); // Rollback if insufficient funds
                return false;
            }

            // Check if toAccount exists
            Account toAccount = getAccountById(toAccountId);
            if (toAccount == null) {
                System.out.println("Transfer failed: 'To' account (ID " + toAccountId + ") not found.");
                conn.rollback(); // Rollback if account not found
                return false;
            }

            // 2. Debit the sender's account
            System.out.println("Debiting " + amount + " from account " + fromAccountId + "...");
            int rowsAffectedDebit = updateAccountBalance(conn, fromAccountId, -amount);
            if (rowsAffectedDebit == 0) {
                throw new SQLException("Debit failed for account " + fromAccountId);
            }

            // Simulate a potential failure point (e.g., network error, power outage)
            // if (fromAccountId == 101 && toAccountId == 102 && amount == 200.0) {
            //     System.out.println("Simulating a failure after debit...");
            //     throw new SQLException("Simulated network error.");
            // }

            // 3. Credit the receiver's account
            System.out.println("Crediting " + amount + " to account " + toAccountId + "...");
            int rowsAffectedCredit = updateAccountBalance(conn, toAccountId, amount);
            if (rowsAffectedCredit == 0) {
                throw new SQLException("Credit failed for account " + toAccountId);
            }

            // 4. If both operations succeed, commit the transaction
            conn.commit();
            System.out.println("Transaction committed successfully.");
            return true;

        } catch (SQLException e) {
            // 5. If any operation fails, rollback the transaction
            if (conn != null) {
                try {
                    System.err.println("Transaction failed! Rolling back...");
                    conn.rollback();
                    System.err.println("Rollback successful.");
                } catch (SQLException ex) {
                    System.err.println("Error during rollback: " + ex.getMessage());
                }
            }
            System.err.println("SQL Exception during transfer: " + e.getMessage());
            // e.printStackTrace(); // For debugging
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during transfer: " + e.getMessage());
        } finally {
            // 6. Restore auto-commit mode in the connection (important if reusing connection)
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    System.err.println("Error resetting auto-commit: " + e.getMessage());
                }
                try {
                    conn.close(); // Close the connection
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
            System.out.println("Transfer attempt finished.");
        }
        return false;
    }
}

// --- Main Class to demonstrate Transaction Handling ---
public class JdbcTransactionExample {

    public static void main(String[] args) {
        System.out.println("JDBC Transaction Handling Example");
        System.out.println("---------------------------------\n");

        AccountDAO accountDAO = new AccountDAO();

        // --- Initial Balances ---
        System.out.println("--- Initial Account Balances ---");
        displayBalance(accountDAO, 101);
        displayBalance(accountDAO, 102);
        displayBalance(accountDAO, 103);
        System.out.println();

        // --- Scenario 1: Successful Transfer ---
        System.out.println("\n--- Scenario 1: Successful Transfer (Alice to Bob, 200.00) ---");
        if (accountDAO.transferMoney(101, 102, 200.00)) {
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed!");
        }
        System.out.println("\n--- Balances After Successful Transfer ---");
        displayBalance(accountDAO, 101);
        displayBalance(accountDAO, 102);
        displayBalance(accountDAO, 103);
        System.out.println();

        // --- Scenario 2: Failed Transfer (Insufficient Funds) ---
        System.out.println("\n--- Scenario 2: Failed Transfer (Charlie to Alice, 1000.00 - Insufficient Funds) ---");
        if (accountDAO.transferMoney(103, 101, 1000.00)) {
            System.out.println("Transfer successful!"); // This should not happen
        } else {
            System.out.println("Transfer failed as expected (insufficient funds).");
        }
        System.out.println("\n--- Balances After Failed Transfer (Should be unchanged for Charlie/Alice) ---");
        displayBalance(accountDAO, 101);
        displayBalance(accountDAO, 102);
        displayBalance(accountDAO, 103);
        System.out.println();

        // --- Scenario 3: Failed Transfer (Non-existent 'To' Account) ---
        System.out.println("\n--- Scenario 3: Failed Transfer (Bob to NonExistentAccount, 50.00) ---");
        if (accountDAO.transferMoney(102, 999, 50.00)) {
            System.out.println("Transfer successful!"); // This should not happen
        } else {
            System.out.println("Transfer failed as expected (non-existent 'To' account).");
        }
        System.out.println("\n--- Balances After Failed Transfer (Should be unchanged for Bob/NonExistent) ---");
        displayBalance(accountDAO, 101);
        displayBalance(accountDAO, 102);
        displayBalance(accountDAO, 103);
        System.out.println();

        System.out.println("\nProgram execution completed.");
    }

    private static void displayBalance(AccountDAO dao, int accountId) {
        Account account = dao.getAccountById(accountId);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account with ID " + accountId + " not found.");
        }
    }
}