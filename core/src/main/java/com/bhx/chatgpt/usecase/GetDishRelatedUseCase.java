package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestionMessageRequire;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface GetDishRelatedUseCase {
    Collection<ChatGPTSuggestionMessageRequire.Dish> execute(String content);
}
