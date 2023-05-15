package com.bhx.product.delivery.impl;

import com.bhx.product.delivery.ProductController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductControllerImpl implements ProductController {
    @Override
    @GetMapping({"/", "/index"})
    public String index(Model model) {
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
}
