package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.ports.CategoryRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class GetOneCategoryUseCaseImpl implements  GetOneCategoryUseCase{
    private final CategoryRepositoryService categoryRepositoryService;
    @Override
    public Optional<Category> execute(String id) {
        return categoryRepositoryService.getCategoryById(id);
    }
}
