package com.bhx.delivery;

import java.util.Collection;

import com.bhx.delivery.responses.NetflixResponse;
import com.bhx.delivery.rest.CategoryRest;
import com.bhx.shared.exceptions.NetflixException;

public interface CategoryController {

	NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException;

}
