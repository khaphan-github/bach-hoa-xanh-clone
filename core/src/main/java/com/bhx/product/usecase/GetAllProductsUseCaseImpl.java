package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */

@AllArgsConstructor
public class GetAllProductsUseCaseImpl implements GetAllProductsUseCase {

    private final ProductRepositoryService productRepositoryService;

    @Override
    public Collection<Product> execute() throws ProductNotFoundException {
        Collection<Product> productsStored = productRepositoryService.getProducts();
        if (productsStored.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return productsStored;
    }
}
