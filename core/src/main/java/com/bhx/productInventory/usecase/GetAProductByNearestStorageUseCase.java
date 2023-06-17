package com.bhx.productInventory.usecase;

import com.bhx.product.Product;

import java.io.IOException;
import java.util.List;

public interface GetAProductByNearestStorageUseCase {
    public Product excute(double lon, double lat) throws IOException, InterruptedException;
}
