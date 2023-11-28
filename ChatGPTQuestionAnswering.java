import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatGPTQuestionAnswering {

    private static final String AUTHORIZATION_TOKEN = "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"; // Replace with your actual API key
    private static final String MODEL = "gpt-3.5-turbo";
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/engines/" + MODEL + "/completions";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Ask a question: ");
            String userQuestion = reader.readLine();
            String answer = chatGPT(userQuestion);
            System.out.println("Answer: " + answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String chatGPT(String question) {
        try {
            URL url = new URL(OPENAI_API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", AUTHORIZATION_TOKEN);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
    
            int responseCode = con.getResponseCode();  // Declaration here
    
            if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                throw new RuntimeException("Unauthorized access. Check your API key and permissions. Response Code: " + responseCode);
            }
    
            String requestBody = "{\"prompt\": \"" + question + "\", \"max_tokens\": 150}";
            try (OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream())) {
                writer.write(requestBody);
            }
    
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
    
            return extractContentFromResponse(response.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    

    private static String extractContentFromResponse(String response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);
            // Assuming the response contains a 'choices' field with 'text' as the answer
            return jsonNode.get("choices").get(0).get("text").asText();
        } catch (IOException e) {
            throw new RuntimeException("Error extracting content from response", e);
        }
    }
}
