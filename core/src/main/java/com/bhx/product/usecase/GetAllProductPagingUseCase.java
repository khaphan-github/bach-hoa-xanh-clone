package com.bhx.product.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.PagingWrongFormat;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface GetAllProductPagingUseCase {
    Collection<Product> execute(int page, int size) throws PagingWrongFormat;
}
