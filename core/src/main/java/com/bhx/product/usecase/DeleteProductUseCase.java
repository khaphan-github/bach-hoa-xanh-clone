package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductAlreadyExistException;

public interface DeleteProductUseCase {
    void execute(String id);
}
