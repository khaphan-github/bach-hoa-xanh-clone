package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class InValidProductUseCaseImpl implements InValidProductUseCase {

    private final ProductRepositoryService productRepositoryService;

    @Override
    public void execute(String id) throws ProductNotFoundException {
        Product productStored = productRepositoryService.getProductById(id);
        if (productStored == null) {
            throw new ProductNotFoundException();
        }
        productRepositoryService.inValidProductById(id);
    }
}
