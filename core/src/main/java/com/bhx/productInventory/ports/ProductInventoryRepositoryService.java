package com.bhx.productInventory.ports;

import com.bhx.product.Product;
import com.bhx.product.exception.PagingWrongFormat;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.productInventory.ProductInventory;
import com.bhx.storage.Storage;

import java.util.Collection;
import java.util.List;

public interface ProductInventoryRepositoryService {

    public boolean saveProductInventory(ProductInventory productInventory);
    public List<Product> getProductByStorageId(String id) throws ProductNotFoundException;
    public Product getAProductByStorageId(String storageId, String productId) throws ProductNotFoundException;

    public ProductInventory getProductInventoryByStorageIdAndProductId(String storageId, String productId);

    public Collection<Product> getAllProductWithPaging(int page, int size, String storageId) throws PagingWrongFormat, ProductNotFoundException;
    public Product getAProductDetail(String StorageId, String ProductId) throws ProductNotFoundException;
}
