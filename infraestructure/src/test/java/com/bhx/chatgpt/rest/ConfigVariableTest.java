package com.bhx.chatgpt.rest;

import com.bhx.chatgptsuggestion.configuration.ConfigVariable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author "KhaPhan" on 15-May-23
 * @project clean-architecture
 */
@TestPropertySource(locations="classpath:application.properties")
@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class ConfigVariableTest {
    @Mock
    private ConfigVariable configVariable;

    @BeforeEach
    public void setUp() {
        configVariable = new ConfigVariable();
    }

    @Test
    public void testGetChatGPTEndpoint() {
        String expectedEndpoint = "https://api.openai.com/v1/chat/completions";

        String actualEndpoint = configVariable.getEndpoint();

        assertEquals(expectedEndpoint, actualEndpoint);
    }

    @Test
    public void testGetChatGPTSecretKey() {
        String expectedSecretKey = "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";

        String actualSecretKey = configVariable.getSecretKey();

        assertEquals(expectedSecretKey, actualSecretKey);
    }

    @Test
    public void testGetChatGPTModel() {
        String expectedModel = "gpt-3.5-turbo-0301";

        String actualModel = configVariable.getModel();

        assertEquals(expectedModel, actualModel);
    }
}
