package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.PagingWrongFormat;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class GetAllProductPagingUseCaseImpl implements GetAllProductPagingUseCase {
    private final ProductRepositoryService productRepositoryService;

    @Override
    public Collection<Product> execute(int page, int size) throws PagingWrongFormat {
        if (page >= 0 && size >= 0) {
            return productRepositoryService.getProductsPaging(page, size);
        }
        throw new PagingWrongFormat();
    }
}
