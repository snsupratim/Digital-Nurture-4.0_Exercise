import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1"; // Loopback address for localhost
    private static final int SERVER_PORT = 12345;        // Must match server's port

    public static void main(String[] args) {
        System.out.println("Chat Client connecting to " + SERVER_IP + ":" + SERVER_PORT + "...");

        // Use try-with-resources to ensure sockets are closed automatically
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             // Get output stream to server and wrap in PrintWriter for text
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // 'true' for auto-flush
             // Get input stream from server and wrap in BufferedReader for text
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner clientInput = new Scanner(System.in)) { // For client to send messages

            System.out.println("Connected to the chat server.");
            System.out.println("Type 'bye' to exit the chat.");

            String clientMessage;
            String serverResponse;

            // Chat loop: client sends message first, then waits for server reply
            while (true) {
                // Client sends a message
                System.out.print("Client (You): ");
                clientMessage = clientInput.nextLine();
                out.println(clientMessage); // Send message to server

                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client said bye. Disconnecting.");
                    break; // Exit loop if client says "bye"
                }

                // Read server's response
                if ((serverResponse = in.readLine()) != null) {
                    System.out.println("Server: " + serverResponse);
                    if (serverResponse.equalsIgnoreCase("bye")) {
                        System.out.println("Server said bye. Disconnecting.");
                        break; // Exit loop if server says "bye"
                    }
                } else {
                    // Server disconnected unexpectedly
                    System.out.println("Server disconnected.");
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Could not connect to server or I/O error: " + e.getMessage());
            // Common errors: Connection refused (server not running or wrong IP/port), broken pipe.
        } finally {
            System.out.println("Chat Client shutting down.");
        }
    }
}