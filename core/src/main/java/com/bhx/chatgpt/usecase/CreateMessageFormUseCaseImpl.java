package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgpt.exception.MessageAlreadyExist;
import com.bhx.chatgpt.ports.ChatGPTSuggestionRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class CreateMessageFormUseCaseImpl implements CreateMessageFormUseCase {

    private final ChatGPTSuggestionRepositoryService chatGPTSuggestionRepositoryService;
    @Override
    public void execute(ChatGPTSuggestion chatGPTSuggestion) throws MessageAlreadyExist {
        chatGPTSuggestionRepositoryService.save(chatGPTSuggestion);
    }
}
