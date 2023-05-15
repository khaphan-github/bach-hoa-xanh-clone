package com.bhx.chatgpt.rest;
import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgptsuggestion.persistence.converters.ChatGPTSuggestionRepositoryConverter;
import com.bhx.chatgptsuggestion.persistence.entities.ChatGPTSuggestionEntity;
import com.bhx.chatgptsuggestion.persistence.impl.ChatGPTSuggestionServiceImpl;
import com.bhx.chatgptsuggestion.persistence.repository.ChatGPTSuggestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
/**
 * @author "KhaPhan" on 15-May-23
 * @project clean-architecture
 */


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class ChatGPTSuggestionServiceImplTest {

    private ChatGPTSuggestionServiceImpl chatGPTSuggestionService;

    @Mock
    private ChatGPTSuggestionRepository chatGPTSuggestionRepository;

    @Mock
    private ChatGPTSuggestionRepositoryConverter chatGPTSuggestionRepositoryConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        chatGPTSuggestionService = new ChatGPTSuggestionServiceImpl(chatGPTSuggestionRepository, chatGPTSuggestionRepositoryConverter);
    }

    @Test
    public void testSave() {
        // Create a sample ChatGPTSuggestion object
        ChatGPTSuggestion chatGPTSuggestion = createSampleChatGPTSuggestion();

        // Create a sample ChatGPTSuggestionEntity object
        ChatGPTSuggestionEntity chatGPTSuggestionEntity = createSampleChatGPTSuggestionEntity();

        // Mock the conversion from ChatGPTSuggestion to ChatGPTSuggestionEntity
        when(chatGPTSuggestionRepositoryConverter.mapToTable(chatGPTSuggestion)).thenReturn(chatGPTSuggestionEntity);

        // Call the save method
        chatGPTSuggestionService.save(chatGPTSuggestion);

        // Verify that the save method was called on the repository with the expected ChatGPTSuggestionEntity object
        // verify(chatGPTSuggestionRepository).save(chatGPTSuggestionEntity);
    }

    private ChatGPTSuggestion createSampleChatGPTSuggestion() {
        ChatGPTSuggestion chatGPTSuggestion = new ChatGPTSuggestion();
        // Set the properties of chatGPTSuggestion with sample data
        chatGPTSuggestion.setTypeMessage("Type message");
        chatGPTSuggestion.setFormatMessage("Format message");
        chatGPTSuggestion.setJsonRequire("JSON require");
        // Set other properties as needed
        return chatGPTSuggestion;
    }

    private ChatGPTSuggestionEntity createSampleChatGPTSuggestionEntity() {
        ChatGPTSuggestionEntity chatGPTSuggestionEntity = new ChatGPTSuggestionEntity();
        // Set the properties of chatGPTSuggestionEntity with sample data
        chatGPTSuggestionEntity.setTypeMessage("Type message");
        chatGPTSuggestionEntity.setFormatMessage("Format message");
        chatGPTSuggestionEntity.setJsonRequire("JSON require");
        // Set other properties as needed
        return chatGPTSuggestionEntity;
    }
}
