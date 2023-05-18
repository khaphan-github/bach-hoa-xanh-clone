package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.category.ports.CategoryRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase{

    private CategoryRepositoryService categoryRepositoryService;

    @Override
    public void execute(Category category) throws CategoryAlreadyExistException {

        if(Boolean.TRUE.equals(categoryRepositoryService.doesCategoryNameExists(category.getName()))) {
            categoryRepositoryService.updateCategory(category);
        }


    }
}
