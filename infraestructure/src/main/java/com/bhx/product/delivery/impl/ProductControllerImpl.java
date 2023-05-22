package com.bhx.product.delivery.impl;

import com.bhx.product.delivery.ProductController;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.delivery.converters.view.ProductView;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final GetAllProductsUseCase getAllProductsUseCase;

    private final ProductMvcConverter productMvcConverter;
    @Override
    @GetMapping({"/", "/index"})
    public String index(Model model) throws ProductNotFoundException {
        model.addAttribute("active","home");



        return "public/home/index";
    }

    @Override
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("active","contact");
        return "public/contact/index";
    }

    @Override
    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("active","shop");
        return "public/shop/index";
    }

    @Override
    @GetMapping("/direct/details")
    public String direct_detail(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/details";
    }

    @Override
    @GetMapping("/direct/shopping_cart")
    public String direct_shopping_cart(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/shopping_cart";
    }

    @Override
    @GetMapping("/direct/checkout")
    public String direct_checkout(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/checkout";
    }

    @Override
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("selected","dashboard");
        return "admin/main/index";
    }

    @Override
    @GetMapping("/admin/products")
    public String admin_products(Model model) {
        model.addAttribute("selected","products");
        return "admin/products/index";
    }

    @Override
    @GetMapping("/error/test")
    public String error() {
        return "_layout/error/test";
    }
}
