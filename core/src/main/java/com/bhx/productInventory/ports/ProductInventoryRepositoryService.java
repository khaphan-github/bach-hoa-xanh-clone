package com.bhx.productInventory.ports;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.productInventory.ProductInventory;
import com.bhx.storage.Storage;

import java.util.Collection;
import java.util.List;

public interface ProductInventoryRepositoryService {
    public boolean saveProductInventory(ProductInventory productInventory);
    public List<Product> getProductIdsByStorageId(String id) throws ProductNotFoundException;
}
