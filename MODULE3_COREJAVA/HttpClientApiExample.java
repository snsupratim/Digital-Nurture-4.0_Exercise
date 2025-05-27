import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
// import com.fasterxml.jackson.databind.JsonNode; // For Jackson
// import com.fasterxml.jackson.databind.ObjectMapper; // For Jackson
// import com.google.gson.Gson; // For Gson
// import com.google.gson.JsonObject; // For Gson

public class HttpClientApiExample {

    public static void main(String[] args) {
        System.out.println("Java 11+ HTTP Client API Demonstration");
        System.out.println("--------------------------------------\n");

        // 1. Define the API endpoint and the username
        String githubUsername = "octocat"; // A well-known GitHub test user
        String apiUrl = "https://api.github.com/users/" + githubUsername;

        // 2. Create an HttpClient instance
        // HttpClient.newHttpClient() creates a default client.
        // You can customize it with HttpClient.newBuilder()...build();
        HttpClient client = HttpClient.newHttpClient();

        // 3. Build an HttpRequest for a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl)) // Set the URI for the request
                .GET() // Specify the HTTP method (GET, POST, PUT, DELETE, etc.)
                .build(); // Build the immutable HttpRequest object

        System.out.println("Attempting to fetch data from: " + apiUrl + "\n");

        try {
            // 4. Send the request and get the HttpResponse
            // HttpResponse.BodyHandlers.ofString() specifies that the response body
            // should be handled as a String. Other handlers include ofByteArray(), ofFile(), etc.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 5. Print the response status code and body
            System.out.println("--- HTTP Response ---");
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body (first 500 chars):\n" + response.body().substring(0, Math.min(response.body().length(), 500)) + "...");
            System.out.println("---------------------\n");

            // Optional: Parse JSON response using Jackson or Gson
            System.out.println("--- JSON Parsing (Optional - requires external libraries) ---");
            String responseBody = response.body();

            // Uncomment the following block if you have Jackson or Gson added to your project's classpath.
            // For Jackson: Add 'com.fasterxml.jackson.core:jackson-databind' dependency
            // For Gson: Add 'com.google.code.gson:gson' dependency

            /*
            // Example using Jackson ObjectMapper
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                String name = jsonNode.has("name") ? jsonNode.get("name").asText() : "N/A";
                String company = jsonNode.has("company") ? jsonNode.get("company").asText() : "N/A";
                int publicRepos = jsonNode.has("public_repos") ? jsonNode.get("public_repos").asInt() : 0;

                System.out.println("Parsed JSON (Jackson):");
                System.out.println("  Name: " + name);
                System.out.println("  Company: " + company);
                System.out.println("  Public Repos: " + publicRepos);
            } catch (Exception e) {
                System.err.println("Error parsing JSON with Jackson: " + e.getMessage());
            }

            // Example using Gson
            try {
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
                String name = jsonObject.has("name") && !jsonObject.get("name").isJsonNull() ? jsonObject.get("name").getAsString() : "N/A";
                String company = jsonObject.has("company") && !jsonObject.get("company").isJsonNull() ? jsonObject.get("company").getAsString() : "N/A";
                int publicRepos = jsonObject.has("public_repos") ? jsonObject.get("public_repos").getAsInt() : 0;

                System.out.println("\nParsed JSON (Gson):");
                System.out.println("  Name: " + name);
                System.out.println("  Company: " + company);
                System.out.println("  Public Repos: " + publicRepos);
            } catch (Exception e) {
                System.err.println("Error parsing JSON with Gson: " + e.getMessage());
            }
            */
            System.out.println("To enable JSON parsing, add Jackson or Gson library to your project's classpath.");
            System.out.println("For Jackson: Maven: com.fasterxml.jackson.core:jackson-databind");
            System.out.println("For Gson: Maven: com.google.code.gson:gson");


        } catch (IOException e) {
            System.err.println("I/O Error during HTTP request: " + e.getMessage());
            System.err.println("Check network connection or API URL.");
        } catch (InterruptedException e) {
            System.err.println("HTTP request interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid URI or request parameter: " + e.getMessage());
        } finally {
            System.out.println("\nHTTP Client API example finished.");
        }
    }
}