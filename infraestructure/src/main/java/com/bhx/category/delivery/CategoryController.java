package com.bhx.category.delivery;
import com.bhx.category.Category;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.category.persistence.converters.view.CategoryRoot;
import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;

public interface CategoryController {

	String getCategories(Model model) throws ProductNotFoundException;


	public String deleteCategory(String categoryId) throws CategoryAlreadyExistException;


	public String updateCategory(String categoryId, Category category) throws CategoryAlreadyExistException;


	public String createCategory(CategoryRoot category) throws CategoryAlreadyExistException;
}
