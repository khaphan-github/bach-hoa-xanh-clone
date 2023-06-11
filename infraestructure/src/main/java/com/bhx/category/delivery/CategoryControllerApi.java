package com.bhx.category.delivery;

import com.bhx.category.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

public interface CategoryControllerApi{
    public ResponseEntity<List<Category>> getCategoriesByParentId(String parentId);
}
