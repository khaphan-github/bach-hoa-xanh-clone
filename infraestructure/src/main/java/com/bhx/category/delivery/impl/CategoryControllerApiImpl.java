package com.bhx.category.delivery.impl;

import com.bhx.category.Category;
import com.bhx.category.delivery.CategoryControllerApi;
import com.bhx.category.delivery.converters.CategoryJson;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.category.usecase.CreateCategoryUseCase;
import com.bhx.category.usecase.GetCategoryByParentIdUseCase;
import com.bhx.category.usecase.UpdateCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/category/api")
@RequiredArgsConstructor
public class CategoryControllerApiImpl implements CategoryControllerApi {
    private final GetCategoryByParentIdUseCase getCategoryByParentIdUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;

    @Override
    @GetMapping("/getAllByParentId")
    public ResponseEntity<List<Category>> getCategoriesByParentId(@RequestParam("parentId") String parentId) {
        List<Category> categories = getCategoryByParentIdUseCase.execute(parentId)
                .stream()
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }


    @Override
    @PostMapping("/updateCategory")
    public String updateCategory(@RequestBody Category category) {
        updateCategoryUseCase.execute(category);
        return "/admin/category";
    }

    @Override
    @PostMapping("/uploadCategory")
    public ResponseEntity<List<Category>> uploadCsv(@RequestBody List<CategoryJson> categoryArrayList) throws CategoryAlreadyExistException {
        List<Category> productFailed = new ArrayList<>();
        for (CategoryJson obj : categoryArrayList) {
            List<String> keywords = Arrays.asList(obj.getKeywords().split(","));
            Category newCategory = new Category(obj.getParentId(), obj.getName(), obj.getHref(), keywords, null);
            try{
                createCategoryUseCase.execute(newCategory);
            }
            catch (Exception ex)
            {
                productFailed.add(newCategory);
            }
        }
        return ResponseEntity.ok(productFailed);
    }

}
