import java.util.Random;  // For generating random numbers
import java.util.Scanner; // For reading user input

public class NumberGuessingGame {

    public static void main(String[] args) {
        // 1. Generate a random number between 1 and 100
        Random random = new Random();
        // nextInt(100) generates numbers from 0 to 99. Add 1 to get 1 to 100.
        int randomNumber = random.nextInt(100) + 1;

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        int userGuess;
        int guessCount = 0; // To keep track of how many guesses the user makes
        boolean hasGuessedCorrectly = false; // Flag to control the game loop

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have secretly chosen a number between 1 and 100.");
        System.out.println("Can you guess what it is?");

        // 3. Continue until the user guesses correctly
        while (!hasGuessedCorrectly) {
            guessCount++; // Increment guess counter for each attempt

            // 2. Prompt the user to guess the number
            System.out.print("Enter your guess (" + guessCount + ". attempt): ");

            // Input validation: Ensure user enters an integer
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();

                // 4. Provide feedback if the guess is too high or too low
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Your guess is out of range. Please guess a number between 1 and 100.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    // User guessed correctly
                    hasGuessedCorrectly = true;
                    System.out.println("\nCongratulations! You've guessed the number!");
                    System.out.println("The number was " + randomNumber + ".");
                    System.out.println("It took you " + guessCount + " guesses.");
                }
            } else {
                // If the user enters something that's not an integer
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }

        // Close the scanner to release system resources
        scanner.close();
    }
}