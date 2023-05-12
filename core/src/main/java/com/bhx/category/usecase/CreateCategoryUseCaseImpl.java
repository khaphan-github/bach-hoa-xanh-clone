package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.category.ports.CategoryRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public void execute(Category category) throws CategoryAlreadyExistException {

		if(categoryRepositoryService.doesCategoryNameExists(category.getName())) {
			throw new CategoryAlreadyExistException();
		};

		categoryRepositoryService.saveCategory(category);
	}

}
