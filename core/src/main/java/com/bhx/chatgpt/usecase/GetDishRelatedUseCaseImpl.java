package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestionMessageRequire;
import com.bhx.chatgpt.ports.ChatGPTSuggestionApiService;
import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */

@AllArgsConstructor
public class GetDishRelatedUseCaseImpl implements GetDishRelatedUseCase {

    private final ChatGPTSuggestionApiService chatGPTSuggestionApiService;


    @Override
    public Collection<ChatGPTSuggestionMessageRequire.Dish> execute(int top, List<Product> productInCart) {
        return chatGPTSuggestionApiService.getRelatedDishes(top, productInCart);
    }
}
