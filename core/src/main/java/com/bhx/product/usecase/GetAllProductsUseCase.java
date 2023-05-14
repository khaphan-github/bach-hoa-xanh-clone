package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface GetAllProductsUseCase {
    Collection<Product> execute() throws ProductNotFoundException;
}
