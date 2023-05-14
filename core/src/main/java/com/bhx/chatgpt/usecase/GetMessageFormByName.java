package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgpt.exception.MessageNotFound;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface GetMessageFormByName {
    ChatGPTSuggestion execute(String name) throws MessageNotFound;
}
