package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestion;
import com.bhx.chatgpt.ChatGPTSuggestionMessageRequire;
import com.bhx.product.Product;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface GetDishRelatedUseCase {
    Collection<ChatGPTSuggestionMessageRequire.Dish> execute(String content);
}
