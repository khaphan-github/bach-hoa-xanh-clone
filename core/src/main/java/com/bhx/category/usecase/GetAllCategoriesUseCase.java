package com.bhx.category.usecase;

import java.util.Collection;

import com.bhx.category.Category;
import com.bhx.product.exception.ProductNotFoundException;

public interface GetAllCategoriesUseCase {

	public Collection<Category> execute();
	
}
