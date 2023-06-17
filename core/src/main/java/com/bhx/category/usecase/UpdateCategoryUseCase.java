package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.exception.CategoryAlreadyExistException;

public interface UpdateCategoryUseCase {
    public void execute(Category category);
}
