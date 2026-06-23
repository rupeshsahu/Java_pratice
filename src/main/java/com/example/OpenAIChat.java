package com.example;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class OpenAIChat {
    // Default OpenAI endpoint; can be overridden by setting OPENAI_BASE_URL environment variable.
    // If OPENAI_BASE_URL is set to a broker or proxy URL (e.g. https://... ), the program will
    // append the standard path for chat completions.
    // Example env var name: OPENAI_BASE_URL
    // Example value: https://model-broker.example.net

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    // Helper to compute full API URL from environment variable OPENAI_BASE_URL or use default.
    private static String getApiUrl() {
        String base = System.getenv("OPENAI_BASE_URL");
        if (base == null || base.isBlank()) {
            return "https://api.openai.com/v1/chat/completions";
        }
        // strip trailing slash
        if (base.endsWith("/")) base = base.substring(0, base.length() - 1);
        // If base already contains /v1, append /chat/completions; otherwise append /v1/chat/completions
        if (base.endsWith("/v1")) return base + "/chat/completions";
        if (base.endsWith("/v1/chat/completions")) return base; // already full path
        if (base.contains("/v1/")) return base + "chat/completions";
        return base + "/v1/chat/completions";
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Please set the OPENAI_API_KEY environment variable.");
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your prompt (finish with an empty line):");

        StringBuilder promptBuilder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line == null || line.isEmpty()) break;
            promptBuilder.append(line).append("\n");
        }
        String prompt = promptBuilder.toString().trim();
        if (prompt.isEmpty()) {
            System.out.println("No prompt provided. Exiting.");
            return;
        }

        try {
            String responseText = callOpenAI(apiKey, prompt);
            System.out.println("=== OpenAI Response ===");
            System.out.println(responseText);
        } catch (IOException e) {
            System.err.println("Error calling OpenAI API: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String callOpenAI(String apiKey, String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();

        JSONObject message = new JSONObject()
                .put("role", "user")
                .put("content", prompt);

        JSONArray messages = new JSONArray().put(message);

        JSONObject bodyJson = new JSONObject()
                .put("model", "gpt-3.5-turbo")
                .put("messages", messages)
                .put("temperature", 0.7);

        RequestBody requestBody = RequestBody.create(bodyJson.toString(), JSON);

        Request request = new Request.Builder()
                .url(getApiUrl())
                .post(requestBody)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errBody = response.body() != null ? response.body().string() : "";
                throw new IOException("Unexpected code " + response.code() + " - " + errBody);
            }
            String respBody = response.body() != null ? response.body().string() : "";
            JSONObject respJson = new JSONObject(respBody);

            // Extract assistant message (first choice)
            JSONArray choices = respJson.optJSONArray("choices");
            if (choices != null && choices.length() > 0) {
                JSONObject first = choices.getJSONObject(0);
                JSONObject messageObj = first.optJSONObject("message");
                if (messageObj != null) {
                    return messageObj.optString("content", "").trim();
                }
            }

            return respJson.toString(2);
        }
    }
}

