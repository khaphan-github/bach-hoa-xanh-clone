package com.bhx.rootcategory.persistence.converters;

import com.bhx.global.shared.RepositoryConverter;
import com.bhx.product.Product;
import com.bhx.product.persistence.entities.ProductEntity;
import com.bhx.rootcategory.RootCategory;
import com.bhx.rootcategory.persistence.entities.RootCategoryEntity;

public class RootCategoryRepositoryConverter implements RepositoryConverter<RootCategoryEntity, RootCategory> {
    @Override
    public RootCategoryEntity mapToTable(final RootCategory persistenceObject) {
        return new RootCategoryEntity(
                persistenceObject.getId(),
                persistenceObject.getName()
        );
    }

    @Override
    public RootCategory mapToEntity(final RootCategoryEntity entityObject) {
        return new RootCategory(
                entityObject.getId(),
                entityObject.getName()
        );
    }
}
