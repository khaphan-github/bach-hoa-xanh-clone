package com.bhx.chatgptsuggestion.persistence.converters;

import com.bhx.category.Category;
import com.bhx.category.persistence.entities.CategoryEntity;
import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgptsuggestion.persistence.entities.ChatGPTSuggestionEntity;
import com.bhx.global.shared.RepositoryConverter;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public class ChatGPTSuggestionRepositoryConverter implements RepositoryConverter<ChatGPTSuggestionEntity, ChatGPTSuggestion> {
    @Override
    public ChatGPTSuggestionEntity mapToTable(final ChatGPTSuggestion persistenceObject) {
        return new ChatGPTSuggestionEntity(
                persistenceObject.getId(),
                persistenceObject.getTypeMessage(),
                persistenceObject.getFormatMessage(),
                persistenceObject.getJsonRequire(),
                persistenceObject.getCreatedDate(),
                persistenceObject.getUpdatedDate());
    }

    @Override
    public ChatGPTSuggestion mapToEntity(final ChatGPTSuggestionEntity entityObject) {
        return new ChatGPTSuggestion(
                entityObject.getId(),
                entityObject.getTypeMessage(),
                entityObject.getFormatMessage(),
                entityObject.getJsonRequire(),
                entityObject.getCreatedDate(),
                entityObject.getUpdatedDate());
    }
}
