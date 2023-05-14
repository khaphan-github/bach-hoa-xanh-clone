package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductAlreadyExistException;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepositoryService productRepositoryService;

    @Override
    public void execute(Product product) throws ProductAlreadyExistException {
        boolean isExistProduct = productRepositoryService.isExistProductByName(product.getName());

        if (isExistProduct) {
             throw new ProductAlreadyExistException();
        }

        productRepositoryService.saveProduct(product);
    }
}
