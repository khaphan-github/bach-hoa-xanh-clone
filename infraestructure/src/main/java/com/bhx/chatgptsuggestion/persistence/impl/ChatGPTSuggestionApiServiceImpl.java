package com.bhx.chatgptsuggestion.persistence.impl;

import com.bhx.chatgpt.ChatGPTSuggestionApiResponse;
import com.bhx.chatgpt.ChatGPTSuggestionMessageRequire;
import com.bhx.chatgpt.ports.ChatGPTSuggestionApiService;
import com.bhx.chatgptsuggestion.configuration.ConfigVariable;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class ChatGPTSuggestionApiServiceImpl implements ChatGPTSuggestionApiService {

    private final ConfigVariable configVariable;

    private ChatGPTSuggestionApiResponse getResponse(String content) {
        RestTemplate restTemplate = new RestTemplate();
        String url = configVariable.getChatGPTEndpoint();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", configVariable.getChatGPTModel());

        List<Map<String, String>> messagesList = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", content);
        messagesList.add(message);

        requestBody.put("messages", messagesList);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ChatGPTSuggestionApiResponse response =
                restTemplate.postForObject(url, request, ChatGPTSuggestionApiResponse.class);

        return response;
    }

    @Override
    public Collection<ChatGPTSuggestionMessageRequire.Dish> getRelatedDishes(String content) {
        // TODO: parse data receive from chat gpt;
        ChatGPTSuggestionApiResponse apiResponse = getResponse(content);
        String receiveContent = Arrays.stream(apiResponse.getChoices())
                .findFirst()
                .get()
                .getMessage()
                .getContent();

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
