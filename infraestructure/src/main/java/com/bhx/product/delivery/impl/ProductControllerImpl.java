package com.bhx.product.delivery.impl;

import com.bhx.category.usecase.GetAllCategoriesUseCase;
import com.bhx.product.Product;
import com.bhx.product.delivery.ProductController;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.delivery.converters.view.ProductView;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;
import com.bhx.product.usecase.GetOneProductUseCase;
import com.bhx.webconfig.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final GetAllProductsUseCase getAllProductsUseCase;

    private final ProductMvcConverter productMvcConverter;

    @Autowired
    private EmailService emailService;
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
    @GetMapping("/admin/login")
    @Override
    public String show_admin_login() {
        return "admin/auth/login";
    }

    @Override
    @GetMapping("/admin/products")
    public String admin_products(Model model) throws ProductNotFoundException {
        model.addAttribute("selected","products");
        List<Product> products = getAllProductsUseCase.execute().stream().collect(Collectors.toList());
        System.out.println(products.get(0).toString());
        model.addAttribute("list_products",products);
        try {
            emailService.sendEmail("ledothanhdat1208@gmail.com","Test","Khánh ngu");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "admin/products/index";
    }
}
