package com.bhx.chatgpt.usecase;

import com.bhx.chatgpt.ChatGPTSuggestionMessageRequire;
import com.bhx.product.exception.ProductNotFoundException;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface GetProductRelatedUseCase {
    Collection<ChatGPTSuggestionMessageRequire.RelatedProduct> execute(String content)
            throws ProductNotFoundException;
}
