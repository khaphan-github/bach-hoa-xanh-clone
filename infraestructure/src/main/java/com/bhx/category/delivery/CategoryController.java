package com.bhx.category.delivery;

import com.bhx.category.delivery.responses.NetflixResponse;
import com.bhx.category.delivery.rest.CategoryRest;
import com.bhx.global.exceptions.NetflixException;
import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;

public interface CategoryController {

	String getCategories(Model model) throws NetflixException, ProductNotFoundException;

	NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException;

}
