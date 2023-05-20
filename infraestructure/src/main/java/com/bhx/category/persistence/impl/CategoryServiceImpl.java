package com.bhx.category.persistence.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bhx.category.Category;
import com.bhx.category.persistence.converters.CategoryRepositoryConverter;
import com.bhx.category.persistence.entities.CategoryEntity;
import com.bhx.category.persistence.repositories.CategoryRepository;
import com.bhx.category.ports.CategoryRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryRepositoryService {

	private final CategoryRepository categoryRepository;

	private final CategoryRepositoryConverter categoryRepositoryConverter;

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll().stream()
				.map(category -> categoryRepositoryConverter.mapToEntity(category))
				.collect(Collectors.toList());
		
	}

	@Override
	public void saveCategory(final Category category) {
		categoryRepository.save(categoryRepositoryConverter.mapToTable(category));
	}

	@Override
	public void updateCategory(Category category) {
		Optional<CategoryEntity> categoryFind = categoryRepository.findById(category.getId());
		categoryFind.ifPresent(categoryEntity -> {
			// Update the category entity with the new data
			categoryEntity.setName(category.getName());
			categoryEntity.setAvailable(category.getAvailable());
			categoryEntity.setParent_id(category.getParent_id());
			// Save the updated category entity
			categoryRepository.save(categoryEntity);
		});
	}

	@Override
	public void deleteCategory(final String id) {
		Optional<CategoryEntity> categoryFind = categoryRepository.findById(id);
		categoryFind.ifPresent(categoryEntity -> {
			categoryRepository.delete(categoryEntity);
		});
	}
	@Override
	public Optional<Category> getCategoryById(String id) {
		Optional<CategoryEntity> categoryFind = categoryRepository.findById(id);

		return categoryFind.map(categoryRepositoryConverter::mapToEntity);
	}

	public Boolean doesCategoryNameExists(final String name) {
		return !categoryRepository.findByName(name).isEmpty();
	}

}
