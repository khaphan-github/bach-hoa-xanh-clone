package com.bhx.persistence.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import com.bhx.category.Category;
import com.bhx.category.ports.CategoryRepositoryService;
import com.bhx.persistence.converters.CategoryRepositoryConverter;
import com.bhx.persistence.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryRepositoryService {

	private final CategoryRepository categoryRepository;

	private final CategoryRepositoryConverter categoryRepositoryConverter;

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll().stream().map(category -> categoryRepositoryConverter.mapToEntity(category))
				.collect(Collectors.toList());
		
	}

	@Override
	public void saveCategory(final Category category) {
		categoryRepository.save(categoryRepositoryConverter.mapToTable(category));
	}

	public Boolean doesCategoryNameExists(final String name) {
		return !categoryRepository.findByName(name).isEmpty();
	}

}
