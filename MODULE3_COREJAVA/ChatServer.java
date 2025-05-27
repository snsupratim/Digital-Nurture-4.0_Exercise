import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    private static final int PORT = 12345; // Port to listen on

    public static void main(String[] args) {
        System.out.println("Chat Server starting on port " + PORT + "...");

        // Use try-with-resources to ensure sockets are closed automatically
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is waiting for a client connection...");

            // Accept a client connection
            // serverSocket.accept() blocks until a client connects
            try (Socket clientSocket = serverSocket.accept();
                 // Get input stream from client and wrap in BufferedReader for text
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 // Get output stream to client and wrap in PrintWriter for text
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // 'true' for auto-flush
                 Scanner serverInput = new Scanner(System.in)) { // For server to send messages

                System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress());

                String clientMessage;
                String serverResponse;

                // Chat loop: server reads client message, then sends its own reply
                while (true) {
                    // Read message from client
                    if ((clientMessage = in.readLine()) != null) {
                        System.out.println("Client: " + clientMessage);
                        if (clientMessage.equalsIgnoreCase("bye")) {
                            System.out.println("Client said bye. Closing connection.");
                            break; // Exit loop if client says "bye"
                        }
                    } else {
                        // Client disconnected unexpectedly
                        System.out.println("Client disconnected.");
                        break;
                    }

                    // Server sends a message
                    System.out.print("Server (You): ");
                    serverResponse = serverInput.nextLine();
                    out.println(serverResponse); // Send message to client

                    if (serverResponse.equalsIgnoreCase("bye")) {
                        System.out.println("Server said bye. Closing connection.");
                        break; // Exit loop if server says "bye"
                    }
                }

            } catch (IOException e) {
                System.err.println("Error handling client connection: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Could not listen on port " + PORT + " or I/O error: " + e.getMessage());
        } finally {
            System.out.println("Chat Server shutting down.");
        }
    }
}