package com.bhx.category.ports;

import java.util.Collection;
import java.util.Optional;

import com.bhx.category.Category;

public interface CategoryRepositoryService {

	public Collection<Category> getAllCategories();
	
	public void saveCategory(Category category) ;
	public Category updateCategory(Category category) ;
	public void deleteCategory(String id) ;

	public Optional<Category> getCategoryById(String id);

	public Boolean doesCategoryNameExists(String name);

	public Collection<Category> getAllByParentId(String parentId);
}
