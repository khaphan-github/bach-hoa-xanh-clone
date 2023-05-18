package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.category.ports.CategoryRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class DeleteACategoryUseCaseImpl implements DeleteACategoryUseCase{
    private CategoryRepositoryService categoryRepositoryService;

    @Override
    public void execute(String id) throws CategoryAlreadyExistException {

        if(categoryRepositoryService.getCategoryById(id) != null) {
            categoryRepositoryService.deleteCategory(id);
        }


    }
}
