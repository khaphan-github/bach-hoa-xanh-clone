package com.bhx.product.usecase;

import com.bhx.product.Product;

import java.util.Collection;

public interface GetAllProductByHrefUseCase {
    Collection<Product> execute(String href);
}
