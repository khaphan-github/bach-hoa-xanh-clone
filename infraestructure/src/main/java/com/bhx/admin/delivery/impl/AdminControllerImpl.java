package com.bhx.admin.delivery.impl;

import com.bhx.admin.delivery.AdminController;
import com.bhx.category.Category;
import com.bhx.category.usecase.GetAllCategoriesUseCase;
import com.bhx.product.Product;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;

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
public class AdminControllerImpl implements AdminController {

    private final GetAllProductsUseCase getAllProductsUseCase;

    private final ProductMvcConverter productMvcConverter;

    private final GetAllCategoriesUseCase getAllCategoriesUseCase;


    @GetMapping
    @Override
    public String adminIndex(Model model) {
    model.addAttribute("selected","dashboard");
    return "admin/main/index";
}
    @GetMapping("/login")
    @Override
    public String adminLoginFormView() {
        return "admin/auth/login";
    }

    @PostMapping("/login/auth")
    @Override
    public String adminLoginForm(@RequestParam("username") String username, @RequestParam("password") String password) {

        System.out.println(username+' '+password);
        return "redirect:/admin";
    }


//Product
    @Override
    @GetMapping("/products")
    public String adminProductsView(Model model) throws ProductNotFoundException {
        model.addAttribute("selected","products");
        model.addAttribute("subSelected","listProducts");

        return "admin/products/index";
    }

    @Override
    public String adminProductCategoryView(Model model) {



        return "admin/products/category";
    }
}
