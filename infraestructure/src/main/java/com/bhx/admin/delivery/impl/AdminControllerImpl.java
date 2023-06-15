package com.bhx.admin.delivery.impl;

import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;

import com.bhx.user.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminControllerImpl {
    private final GetAllProductsUseCase getAllProductsUseCase;

    private final ProductMvcConverter productMvcConverter;

    private final LoginUseCase loginUseCase;


    @GetMapping
    public String adminIndex(Model model) {
        model.addAttribute("selected", "dashboard");
        return "admin/main/index";
    }

    @GetMapping("/login")
    public String adminLoginForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "admin/auth/login";
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
