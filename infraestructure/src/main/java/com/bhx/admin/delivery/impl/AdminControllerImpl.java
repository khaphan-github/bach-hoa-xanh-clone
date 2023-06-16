package com.bhx.admin.delivery.impl;

import com.bhx.admin.delivery.AdminController;
import com.bhx.category.Category;
import com.bhx.category.usecase.GetAllCategoriesUseCase;
import com.bhx.product.Product;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;

import com.bhx.user.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminControllerImpl {

    private final GetAllProductsUseCase getAllProductsUseCase;

    private final ProductMvcConverter productMvcConverter;

    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final LoginUseCase loginUseCase;


    @GetMapping
    public String adminIndex(Model model) {
        model.addAttribute("selected", "dashboard");
        return "admin/main/index";
    }


    @GetMapping("/dashboard")
    public String dashBoardPage() {
        return "admin/main/index";
    }

    //Product
    @GetMapping("/products")
    public String adminProductsView(Model model) throws ProductNotFoundException {
        model.addAttribute("selected", "products");
        model.addAttribute("subSelected", "listProducts");

        return "admin/products/index";
    }

    @GetMapping("/products/category")
    public String adminProductCategoryView(Model model) {

        model.addAttribute("selected", "products");
        model.addAttribute("subSelected", "productCategory");

        return "admin/products/category";
    }


}
