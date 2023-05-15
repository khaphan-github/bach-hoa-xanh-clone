package com.bhx.chatgptsuggestion.persistence.impl;

import com.bhx.chatgpt.ChatGPTSuggestionApiResponse;
import com.bhx.chatgpt.ChatGPTSuggestionMessageRequire;
import com.bhx.chatgpt.ports.ChatGPTSuggestionApiService;
import com.bhx.chatgptsuggestion.configuration.ConfigVariable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Slf4j
@AllArgsConstructor
public class ChatGPTSuggestionApiServiceImpl implements ChatGPTSuggestionApiService {

    private final ConfigVariable configVariable;
    private final RestTemplate restTemplate;

    public ResponseEntity<ChatGPTSuggestionApiResponse> getResponse(String content) {
        String url = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer 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");

        String requestBody = "{\"model\": \""
                + "gpt-3.5-turbo-0301"
                + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + content + "\"}]}";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        System.out.println(requestBody);

        return restTemplate.postForEntity(url, request, ChatGPTSuggestionApiResponse.class);
    }

    @Override
    public Collection<ChatGPTSuggestionMessageRequire.Dish> getRelatedDishes(String content) {
        return null;
    }

    @Override
    public Collection<ChatGPTSuggestionMessageRequire.RelatedProduct> getRelatedProducts(String content) {
        return null;
    }

    @Override
    public Collection<ChatGPTSuggestionMessageRequire> getBothRelatedDishesAndProducts(String content) {
        return null;
    }
}
