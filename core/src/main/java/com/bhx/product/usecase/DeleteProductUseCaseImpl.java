package com.bhx.product.usecase;

import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductUseCaseImpl implements DeleteProductUseCase{
    private final ProductRepositoryService productRepositoryService;
    @Override
    public void execute(String id) {
            productRepositoryService.deleteProduct(id);
    }
}
