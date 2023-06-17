package com.bhx.chatgpt.ports;

import com.bhx.chatgpt.ChatGPTSuggestionMessageRequire;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface ChatGPTSuggestionApiService {
    Collection<ChatGPTSuggestionMessageRequire.Dish> getRelatedDishes(String content);
    Collection<ChatGPTSuggestionMessageRequire.RelatedProduct> getRelatedProducts(String content);
    Collection<ChatGPTSuggestionMessageRequire> getBothRelatedDishesAndProducts(String content);
}
