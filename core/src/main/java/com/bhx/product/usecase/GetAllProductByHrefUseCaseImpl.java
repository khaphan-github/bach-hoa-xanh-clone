package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class GetAllProductByHrefUseCaseImpl implements GetAllProductByHrefUseCase{
    private final ProductRepositoryService productRepositoryService;

    @Override
    public Collection<Product> execute(String href) {
        return null;
    }
}
