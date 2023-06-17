package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.ports.CategoryRepositoryService;

import java.util.Collection;

public interface GetAllCategoriesUseCase {
    Collection<Category> execute();
}
