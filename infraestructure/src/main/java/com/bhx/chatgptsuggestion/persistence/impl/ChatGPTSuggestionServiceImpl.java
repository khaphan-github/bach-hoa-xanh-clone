package com.bhx.chatgptsuggestion.persistence.impl;

import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgpt.ports.ChatGPTSuggestionRepositoryService;
import com.bhx.chatgptsuggestion.persistence.converters.ChatGPTSuggestionRepositoryConverter;
import com.bhx.chatgptsuggestion.persistence.entities.ChatGPTSuggestionEntity;
import com.bhx.chatgptsuggestion.persistence.repository.ChatGPTSuggestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class ChatGPTSuggestionServiceImpl implements ChatGPTSuggestionRepositoryService {

    private final ChatGPTSuggestionRepository chatGPTSuggestionRepository;

    private final ChatGPTSuggestionRepositoryConverter chatGPTSuggestionRepositoryConverter;

    @Override
    public void save(ChatGPTSuggestion chatGPTSuggestion) {
        chatGPTSuggestionRepository.save(chatGPTSuggestionRepositoryConverter.mapToTable(chatGPTSuggestion));
    }

    @Override
    public ChatGPTSuggestion getMessageByName(String name) {
        return null;
    }

    @Override
    public void deleteMessageById(String id) {
        chatGPTSuggestionRepository.deleteById(id);
    }
}
