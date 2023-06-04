package com.bhx.product.usecase;

import com.bhx.product.Product;

import java.util.List;

/**
 * @author "KhaPhan" on 22-May-23
 * @project clean-architecture
 */
public interface ImportProductUseCase {
    void execute(List<Product> productList);
}
