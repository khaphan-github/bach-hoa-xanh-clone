package com.bhx.category.delivery;

import java.util.Collection;

import com.bhx.category.delivery.responses.NetflixResponse;
import com.bhx.category.delivery.rest.CategoryRest;
import com.bhx.shared.exceptions.NetflixException;

public interface CategoryController {

	NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException;

}
