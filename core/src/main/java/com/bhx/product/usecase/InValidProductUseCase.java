package com.bhx.product.usecase;

import com.bhx.product.exception.ProductNotFoundException;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface InValidProductUseCase {
    void execute(String id) throws ProductNotFoundException;
}
