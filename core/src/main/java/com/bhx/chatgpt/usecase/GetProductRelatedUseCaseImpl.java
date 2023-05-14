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
public class GetProductRelatedUseCaseImpl implements GetProductRelatedUseCase {

    private final ChatGPTSuggestionApiService chatGPTSuggestionApiService;

    @Override
    public Collection<ChatGPTSuggestionMessageRequire.RelatedProduct> execute(int top, List<Product> productsName)
            throws ProductNotFoundException {
        return chatGPTSuggestionApiService.getRelatedProducts(top, productsName);
    }
}
