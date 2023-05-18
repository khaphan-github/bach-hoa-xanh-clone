package com.bhx.category.persistence.converters;

import com.bhx.category.Category;
import com.bhx.global.shared.RepositoryConverter;
import com.bhx.category.persistence.entities.CategoryEntity;

public class CategoryRepositoryConverter implements RepositoryConverter<CategoryEntity, Category> {

	@Override
	public CategoryEntity mapToTable(final Category persistenceObject) {
		return new CategoryEntity(
				persistenceObject.getId(),
				persistenceObject.getName(),
				persistenceObject.getParent_id(),
				persistenceObject.getAvailable());
	}

	@Override
	public Category mapToEntity(final CategoryEntity entityObject) {
		return new Category(
				entityObject.getId(),
				entityObject.getName(),
				entityObject.getParent_id(),
				entityObject.getAvailable());
	}
}
