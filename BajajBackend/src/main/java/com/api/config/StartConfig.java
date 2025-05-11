package com.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class StartConfig implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Prepare request body
        Map<String, String> requestBody = Map.of(
                "name", "John Doe",
                "regNo", "REG12347",
                "email", "john@example.com"
        );

        // Create HTTP entity with body and headers
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // Send POST request using RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        // Print the response body
        System.out.println("Webhook Response:\n" + response.getBody());
    }
}
