package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author "KhaPhan" on 22-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class ImportProductUseCaseImpl implements ImportProductUseCase {

    private final ProductRepositoryService productRepositoryService;
    @Override
    public void execute(List<Product> productList) {
        productRepositoryService.saveMultipleProduct(productList);
    }
}
