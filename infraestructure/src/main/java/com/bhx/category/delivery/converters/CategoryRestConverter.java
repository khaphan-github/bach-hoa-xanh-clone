package com.bhx.category.delivery.converters;

import com.bhx.category.Category;
import com.bhx.category.delivery.rest.CategoryRest;
import com.bhx.global.shared.RestConverter;

public class CategoryRestConverter implements RestConverter<CategoryRest, Category> {

    @Override
    public Category mapToEntity(final CategoryRest rest) {

        return new Category(rest.getParentId(),rest.getName(),rest.getKeywords(),rest.getAvailable());
    }

    @Override
    public CategoryRest mapToRest(final Category entity) {
        return new CategoryRest(entity.getName(),entity.getParentId(),entity.getKeywords(),entity.getAvailable());
    }

}
