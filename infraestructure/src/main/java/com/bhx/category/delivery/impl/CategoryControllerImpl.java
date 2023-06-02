package com.bhx.category.delivery.impl;

import com.bhx.category.Category;
import com.bhx.category.delivery.CategoryController;
import com.bhx.category.delivery.responses.NetflixResponse;
import com.bhx.category.delivery.rest.CategoryRest;
import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.category.persistence.converters.CategoryRepositoryConverter;
import com.bhx.category.usecase.CreateCategoryUseCase;
import com.bhx.category.usecase.DeleteACategoryUseCase;
import com.bhx.category.usecase.GetAllCategoriesUseCase;
import com.bhx.category.usecase.UpdateCategoryUseCase;
import com.bhx.global.exceptions.NetflixException;
import com.bhx.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteACategoryUseCase deleteACategoryUseCase;
    private final CategoryRepositoryConverter categoryRepositoryConverter;

    @Override
    public NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException {
        // Implement your logic here
        return null;
    }

    @GetMapping("/category")
    public String getCategories(Model model) throws ProductNotFoundException {
        model.addAttribute("active","home");

        List<Category> categories = getAllCategoriesUseCase.execute()
                .stream()
                .collect(Collectors.toList());

        System.out.println("Categories: " + categories.size());
        model.addAttribute("categories", categories);

        return "public/home/index";
    }

    @PostMapping("/category/{id}/delete")
    public String deleteCategory(@PathVariable("id") String categoryId) throws CategoryAlreadyExistException {
        deleteACategoryUseCase.execute(categoryId);
        return "redirect:/category";
    }

    @PostMapping("/category/{id}")
    public String updateCategory(@PathVariable("id") String categoryId, @ModelAttribute Category category) throws CategoryAlreadyExistException {
        category.setId(categoryId);
        updateCategoryUseCase.execute(category);
        return "redirect:/category";
    }

    @PostMapping("/category")
    public String createCategory(@ModelAttribute Category category) throws CategoryAlreadyExistException {
        createCategoryUseCase.execute(category);
        return "redirect:/category";
    }
}
