package com.bhx.chatgpt.rest;

import com.bhx.chatgpt.ChatGPTSuggestionApiResponse;
import com.bhx.chatgptsuggestion.configuration.ChatGPTSuggestionConfiguration;
import com.bhx.chatgptsuggestion.configuration.ConfigVariable;
import com.bhx.chatgptsuggestion.persistence.impl.ChatGPTSuggestionApiServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author "KhaPhan" on 15-May-23
 * @project clean-architecture
 */

@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class ChatGPTSuggestionApiServiceImplTest {

    private ChatGPTSuggestionApiServiceImpl chatGPTSuggestionApiService;

    @Mock
    private ChatGPTSuggestionConfiguration chatGPTSuggestionConfiguration;

    @Mock
    private ConfigVariable configVariable;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        restTemplate = new RestTemplate();
        chatGPTSuggestionApiService = new ChatGPTSuggestionApiServiceImpl(configVariable, restTemplate);
    }

    @Test
    public void testGetResponse() {
        // Mock the config variable values
        String content = "Hi";

        ResponseEntity<ChatGPTSuggestionApiResponse> response = chatGPTSuggestionApiService.getResponse(content);
        log.debug(String.valueOf(response.getBody()));

        assertEquals(200, response.getStatusCode());
    }
}
