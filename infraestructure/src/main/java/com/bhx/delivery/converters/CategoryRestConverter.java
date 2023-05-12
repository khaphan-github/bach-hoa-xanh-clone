package com.bhx.delivery.converters;

import com.bhx.category.Category;
import com.bhx.delivery.rest.CategoryRest;
import com.bhx.shared.RestConverter;

public class CategoryRestConverter implements RestConverter<CategoryRest, Category> {

	@Override
	public Category mapToEntity(final CategoryRest rest) {

		return new Category(null, rest.getName(), rest.getAvailable());
	}

	@Override
	public CategoryRest mapToRest(final Category entity) {
		return new CategoryRest(entity.getName(), entity.getAvailable());
	}

}
