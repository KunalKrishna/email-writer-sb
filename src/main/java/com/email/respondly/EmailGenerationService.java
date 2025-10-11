package com.email.respondly;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGenerationService {

    @Value("${gemini.api.key}")
    private String geminiApiKey; // Assume this is set via constructor or setter

    @Value("${gemini.api.url}")
    private String geminiApiUrl; // Assume this is set via constructor or setter

    private final WebClient webClient;

    public EmailGenerationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String generateEmail(EmailRequest emailRequest) {
        // Logic to generate email using AI model

        // Build the prompt
        // Craft a request
        // Make request and get response
        // return response

        String prompt = buildPrompt(emailRequest);

        Map<String, Object> requestPayload = Map.of(
                "contents", new Object[] {
                        Map.of(
                                "parts", new Object[] {
                                        Map.of("text", prompt)
                                }
                        )
                }
        );
// TODO: Fix null in geminiApiKey and geminiApiUrl
        String response = webClient.post()
                .uri(geminiApiUrl  + geminiApiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestPayload)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return extractResponseContent(response);

//        Client client = Client.builder().apiKey("AIzaSyDvP33MKX8-KK3LiYA_hVS51zDm8Z05Vzo").build();
//
//        GenerateContentResponse response =
//                client.models.generateContent(
//                        "gemini-2.5-flash",
//                        prompt,
//                        null);
//
//        return response.text() ;
    }

    private String extractResponseContent(String response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error parsing request" + e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("Generate a professional email response for the following mail content.\n")
                .append("Please don't generate a subject line.\n");
        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            promptBuilder.append("Use a ").append(emailRequest.getTone()).append("tone.");
        }
        promptBuilder.append("\nOriginal email : \n")
                .append(emailRequest.getEmailContent());
        return promptBuilder.toString();
    }

    @PostConstruct
    public void init() {
        System.out.println("Gemini API Key: " + geminiApiKey);
        System.out.println("Gemini API URL: " + geminiApiUrl);
    }
}
