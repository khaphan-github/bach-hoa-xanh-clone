package com.bhx.admin.delivery.impl;

import com.bhx.admin.delivery.AdminController;
import com.bhx.product.Product;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
@RolesAllowed("ADMIN")
public class AdminControllerImpl implements AdminController {

    private final GetAllProductsUseCase getAllProductsUseCase;

    private final ProductMvcConverter productMvcConverter;


    @GetMapping
    @Override
    public String adminIndex(Model model) {
    model.addAttribute("selected","dashboard");
    return "admin/main/index";
}
    @GetMapping("/login")
    @Override
    public String adminLoginForm() {
        return "admin/auth/login";
    }

    @Override
    @GetMapping("/products")
    public String adminProductsView(Model model) throws ProductNotFoundException {
        model.addAttribute("selected","products");
        List<Product> products = new ArrayList<Product>(getAllProductsUseCase.execute());
        model.addAttribute("list_products",products);
        return "admin/products/index";
    }
}
