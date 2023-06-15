package com.bhx.category.delivery.impl;

import com.bhx.category.Category;
import com.bhx.category.delivery.CategoryController;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.category.persistence.converters.CategoryRepositoryConverter;
import com.bhx.category.persistence.converters.view.CategoryRoot;
import com.bhx.category.usecase.*;
import com.bhx.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/admin/category")
public class CategoryControllerImpl implements CategoryController {
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteACategoryUseCase deleteACategoryUseCase;
    private final CategoryRepositoryConverter categoryRepositoryConverter;

    @Override
    @GetMapping
    public String getCategories(Model model) throws ProductNotFoundException {
        model.addAttribute("selected","products");
        model.addAttribute("subSelected","productCategory");

        List<Category> categories = getAllCategoriesUseCase.execute()
                .stream()
                .collect(Collectors.toList());
        model.addAttribute("categories", categories);
        return "admin/products/category";
    }
    @Override
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") String categoryId) throws CategoryAlreadyExistException {
        deleteACategoryUseCase.execute(categoryId);
        return "redirect:/admin/category";
    }
    @Override
    @PostMapping("/category/{id}")
    public String updateCategory(@PathVariable("id") String categoryId, @ModelAttribute Category category) throws CategoryAlreadyExistException {
        category.setId(categoryId);
        updateCategoryUseCase.execute(category);
        return "redirect:/category";
    }

    @Override
    @PostMapping("/new")
    public String createCategory(@ModelAttribute("newCategory") CategoryRoot category) throws CategoryAlreadyExistException {

        List<String> keywords = (category.getKeywords() == null) ? null : Arrays.asList(category.getKeywords().split(","));

        Category newCategory = new Category(category.getParentId(),category.getName(),category.getHref(),keywords,category.getAvailable());
        createCategoryUseCase.execute(newCategory);
        return "redirect:/admin/category";
    }
}
