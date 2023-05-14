package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgpt.exception.MessageAlreadyExist;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface CreateMessageFormUseCase {
    void execute(ChatGPTSuggestion chatGPTSuggestion) throws MessageAlreadyExist;
}
