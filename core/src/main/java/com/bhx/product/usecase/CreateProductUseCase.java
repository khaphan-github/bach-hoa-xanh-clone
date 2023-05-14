package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductAlreadyExistException;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface CreateProductUseCase {
    void execute(Product product) throws ProductAlreadyExistException;
}
