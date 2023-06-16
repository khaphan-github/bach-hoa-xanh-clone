package com.bhx.product.persistence.converter;

import com.bhx.global.shared.RepositoryConverter;
import com.bhx.product.Product;
import com.bhx.product.persistence.entities.ProductEntity;
import com.bhx.productInventory.ProductInventory;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
public class ProductRepositoryConverter implements RepositoryConverter<ProductEntity, Product> {
    @Override
    public ProductEntity mapToTable(final Product persistenceObject) {
        return new ProductEntity(
                persistenceObject.getId(),
                persistenceObject.getName(),
                persistenceObject.getSearchName(),
                persistenceObject.getDescription(),
                persistenceObject.getThumbImage(),
                persistenceObject.getDescriptionImages(),
                persistenceObject.getOutDate(),
                persistenceObject.getPrice(),
                persistenceObject.getDiscount(),
                persistenceObject.getQuantity(),
                persistenceObject.getCategoryId(),
                persistenceObject.getCreatedDate(),
                persistenceObject.getUpdatedDate(),
                persistenceObject.isAvailable(),
                persistenceObject.getImageLink()
        );
    }

    @Override
    public Product mapToEntity(final ProductEntity entityObject) {
        return new Product(
                entityObject.getId(),
                entityObject.getName(),
                entityObject.getSearchName(),
                entityObject.getDescription(),
                entityObject.getThumbImage(),
                entityObject.getDescriptionImages(),
                entityObject.getOutDate(),
                entityObject.getPrice(),
                entityObject.getDiscount(),
                entityObject.getQuantity(),
                entityObject.getCategoryId(),
                entityObject.getCreatedDate(),
                entityObject.getUpdatedDate(),
                entityObject.isAvailable(),
                0,
                entityObject.getImageLink()
        );
    }

    public Product mapToEntityInventory(final ProductEntity entityObject, ProductInventory inventory) {
        return new Product(
                /*entityObject.getId(),
                entityObject.getName(),
                entityObject.getSearchName(),
                entityObject.getDescription(),
                entityObject.getThumbImage(),
                entityObject.getDescriptionImages(),
                entityObject.getOutDate(),
                entityObject.getPrice(),
                entityObject.getDiscount(),
                entityObject.getQuantity(),
                entityObject.getCategoryId(),
                entityObject.getCreatedDate(),
                entityObject.getUpdatedDate(),
                entityObject.isAvailable(),
                inventory.getInventory()*/
        );
    }
}
