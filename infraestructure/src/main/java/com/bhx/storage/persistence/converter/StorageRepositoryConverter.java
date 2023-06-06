package com.bhx.storage.persistence.converter;

import com.bhx.global.shared.RepositoryConverter;
import com.bhx.product.Product;
import com.bhx.product.persistence.entities.ProductEntity;
import com.bhx.storage.Storage;
import com.bhx.storage.persistence.entities.StorageEntity;

public class StorageRepositoryConverter implements RepositoryConverter<StorageEntity, Storage> {
    @Override
    public StorageEntity mapToTable(final Storage persistenceObject) {
        return new StorageEntity(
                persistenceObject.getId(),
                persistenceObject.getProductId(),
                persistenceObject.getAddress()
        );
    }

    @Override
    public Storage mapToEntity(final StorageEntity entityObject) {
        return new Storage(
                entityObject.getId(),
                entityObject.getProductId(),
                entityObject.getAddress()
        );
    }
}
