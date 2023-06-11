package com.bhx.category.delivery.impl;

import com.bhx.category.Category;
import com.bhx.category.delivery.CategoryControllerApi;
import com.bhx.category.usecase.GetCategoryByParentIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/category/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryControllerApiImpl implements CategoryControllerApi {
    private final GetCategoryByParentIdUseCase getCategoryByParentIdUseCase;

    @Override
    @GetMapping("/getAllByParentId/{parentId}")
    public ResponseEntity<List<Category>> getCategoriesByParentId(@PathVariable("parentId") String parentId) {
        List<Category> categories = getCategoryByParentIdUseCase.execute(parentId)
                .stream()
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }
}
