package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.ports.CategoryRepositoryService;

import java.util.Collection;
import java.util.Optional;

public interface GetOneCategoryUseCase {

    public Optional<Category> execute(String id);
}
