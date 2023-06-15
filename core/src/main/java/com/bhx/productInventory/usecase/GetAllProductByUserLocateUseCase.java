package com.bhx.productInventory.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.PagingWrongFormat;
import com.bhx.product.exception.ProductNotFoundException;

import java.io.IOException;
import java.util.Collection;

public interface GetAllProductByUserLocateUseCase {
    public Collection<Product> excute(int page, int size, double lon, double lat) throws PagingWrongFormat, ProductNotFoundException, IOException, InterruptedException;
}
