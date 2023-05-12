package com.bhx.category.ports;

import java.util.Collection;

import com.bhx.category.Category;

public interface CategoryRepositoryService {

	public Collection<Category> getAllCategories();
	
	public void saveCategory(Category category) ;

	public Boolean doesCategoryNameExists(String name);
}
