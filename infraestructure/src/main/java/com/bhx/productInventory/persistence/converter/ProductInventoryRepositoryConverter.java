package com.bhx.productInventory.persistence.converter;

import com.bhx.global.shared.RepositoryConverter;
import com.bhx.productInventory.ProductInventory;
import com.bhx.productInventory.persistence.entities.ProductInventoryEntity;
import com.bhx.storage.Storage;

public class ProductInventoryRepositoryConverter implements RepositoryConverter<ProductInventoryEntity, ProductInventory> {
    @Override
    public ProductInventoryEntity mapToTable(final ProductInventory persistenceObject) {
        return new ProductInventoryEntity(
                persistenceObject.getProductId(),
                persistenceObject.getStorageId(),
                persistenceObject.getInventory()
        );
    }

    @Override
    public ProductInventory mapToEntity(final ProductInventoryEntity entityObject) {
        return new ProductInventory(
                entityObject.getStorageId(),
                entityObject.getProductId(),
                entityObject.getInventory()
        );
    }
}