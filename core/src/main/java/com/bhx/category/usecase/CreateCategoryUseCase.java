package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.exception.CategoryAlreadyExistException;

public interface CreateCategoryUseCase {

	public void execute(Category category) throws CategoryAlreadyExistException;

}
