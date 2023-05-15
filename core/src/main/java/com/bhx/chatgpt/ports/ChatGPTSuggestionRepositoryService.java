package com.bhx.chatgpt.ports;

import com.bhx.chatgpt.ChatGPTSuggestion;

import java.util.Optional;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface ChatGPTSuggestionRepositoryService {
    void save(ChatGPTSuggestion chatGPTSuggestion);
    ChatGPTSuggestion getMessageByName(String name);
    void deleteMessageById(String id);
}
