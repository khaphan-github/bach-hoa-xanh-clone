package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgpt.exception.MessageNotFound;
import com.bhx.chatgpt.ports.ChatGPTSuggestionRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */

@AllArgsConstructor
public class GetMessageFormByNameImpl implements GetMessageFormByName {

    private final ChatGPTSuggestionRepositoryService chatGPTSuggestionRepositoryService;
    @Override
    public ChatGPTSuggestion execute(String name) throws MessageNotFound {
        return chatGPTSuggestionRepositoryService.getMessageByName(name);
    }
}
