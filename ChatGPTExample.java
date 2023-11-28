import okhttp3.*;

import java.io.IOException;

public class ChatGPTExample {

    private static final String API_ENDPOINT = "https://api.openai.com/v1/engines/davinci-codex/completions";
    private static final String AUTHORIZATION_TOKEN = "Bearer ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■aOSt01Hv";

    public static void main(String[] args) {
        String prompt = "Hello, ChatGPT!";
        int maxTokens = 5;

        try {
            String response = makeApiRequest(prompt, maxTokens);
            System.out.println(response);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error making API request: " + e.getMessage());
            System.err.println("Please check your network connection and try again.");
        }
    }
    private static String makeApiRequest(String prompt, int maxTokens) throws IOException, InterruptedException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"prompt\": \"" + prompt + "\", \"max_tokens\": " + maxTokens + "}");
        Request request = new Request.Builder()
                .url(API_ENDPOINT)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", AUTHORIZATION_TOKEN)
                .build();

        int maxRetries = 1000;
        int delay = 1000; // 1 second delay
        int retryCount = 0;

        while (true) {
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    return response.body().string();
                }

                if (response.code() == 429) {
                    // Too Many Requests - wait and retry
                    if (retryCount < maxRetries) {
                        retryCount++;
                        Thread.sleep((long) delay * retryCount);
                    } else {
                        throw new IOException("API rate limit exceeded - maximum retries reached");
                    }
                } else {
                    throw new IOException("Unexpected response code: " + response.code());
                }
            } catch (IOException e) {
                if (retryCount < maxRetries) {
                    retryCount++;
                    Thread.sleep((long) delay * retryCount);
                } else {
                    throw e;
                }
            }
        }
    }


}