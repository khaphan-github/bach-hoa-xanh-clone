package com.bhx.product.delivery.impl;

import com.bhx.category.Category;
import com.bhx.category.usecase.CreateCategoryUseCase;
import com.bhx.product.delivery.ProductController;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.usecase.GetAllProductsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final ProductMvcConverter productMvcConverter;
    private final CreateCategoryUseCase createCategoryUseCase;
    @Override
    @GetMapping({"/", "/index"})
    public String index(Model model) throws Exception {
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
    public String directDetails(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/details";
    }

    @Override
    @GetMapping("/direct/shopping_cart")
    public String directShoppingCart(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/shopping_cart";
    }

    @Override
    @GetMapping("/direct/checkout")
    public String directCheckout(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/checkout";
    }
}
