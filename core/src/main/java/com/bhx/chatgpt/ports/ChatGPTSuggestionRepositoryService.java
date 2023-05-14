package com.bhx.chatgpt.ports;

import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.product.Product;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface ChatGPTSuggestionRepositoryService {
    void save(ChatGPTSuggestion chatGPTSuggestion);
    ChatGPTSuggestion getMessageByName(String name);
    void deleteMessageById(String id);
}
