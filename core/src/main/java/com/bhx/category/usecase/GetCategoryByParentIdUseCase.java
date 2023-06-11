package com.bhx.category.usecase;

import com.bhx.category.Category;

import java.util.Collection;

public interface GetCategoryByParentIdUseCase {
    public Collection<Category> execute(String parentId);
}
