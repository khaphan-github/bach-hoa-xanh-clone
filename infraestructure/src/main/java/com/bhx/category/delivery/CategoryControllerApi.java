package com.bhx.category.delivery;

import com.bhx.category.Category;
import com.bhx.category.delivery.converters.CategoryJson;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.mongodb.lang.Nullable;
import com.mongodb.util.JSON;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CategoryControllerApi{
    public ResponseEntity<List<Category>> getCategoriesByParentId(String parentId);
    public String updateCategory(Category category) throws CategoryAlreadyExistException;

    public ResponseEntity<List<Category>> uploadCsv(List<CategoryJson> categories) throws CategoryAlreadyExistException;
}
