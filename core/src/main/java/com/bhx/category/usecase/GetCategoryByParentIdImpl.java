package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.ports.CategoryRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class GetCategoryByParentIdImpl implements GetCategoryByParentIdUseCase{

    private final CategoryRepositoryService categoryRepositoryService;
    @Override
    public Collection<Category> execute(String parentId) {

        return categoryRepositoryService.getAllByParentId(parentId);
    }
}
