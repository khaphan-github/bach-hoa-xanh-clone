package com.bhx.storage.usecase;

import com.bhx.product.Product;
import com.bhx.storage.Storage;

import java.util.Collection;

public interface GetAllProductByStorageIdPagingUseCase {
    public Collection<Product> excute(String storaegId);
}
