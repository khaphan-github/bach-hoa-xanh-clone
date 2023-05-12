package com.bhx.category.usecase;

import java.util.Collection;

import com.bhx.category.Category;
import com.bhx.category.ports.CategoryRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public Collection<Category> execute() {
		return categoryRepositoryService.getAllCategories();
	}

}
