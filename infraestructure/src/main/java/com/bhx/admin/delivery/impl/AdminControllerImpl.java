package com.bhx.admin.delivery.impl;

import com.bhx.admin.delivery.AdminController;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;

import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.exception.UserNotFoundException;
import com.bhx.securityconfig.user.exception.WrongUsernameOrPasswordException;
import com.bhx.securityconfig.user.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
@RolesAllowed("ADMIN")
public class AdminControllerImpl implements AdminController {

    private final GetAllProductsUseCase getAllProductsUseCase;

    private final ProductMvcConverter productMvcConverter;

    private final LoginUseCase loginUseCase;


    @GetMapping
    @Override
    public String adminIndex(Model model) {
        model.addAttribute("selected", "dashboard");
        return "admin/main/index";
    }

    @GetMapping("/login")
    @Override
    public String adminLoginForm() {
        return "admin/auth/login";
    }

    @PostMapping("/login")
    @Override
    public String handleLogin(
            @RequestParam("email-username") String emailOrUsername,
            @RequestParam("password") String password,
            @RequestParam(value = "remember-me", required = false) boolean rememberMe,
            Model model
    ) {
        try {
            Account account = this.loginUseCase.execute(emailOrUsername, password);
        } catch (Exception ex) {
            if (ex instanceof UserNotFoundException) {
                model.addAttribute("error", "User not found");
            }
            if (ex instanceof WrongUsernameOrPasswordException) {
                model.addAttribute("error", "Invalid email/username or password");
            }
        }
        return "redirect:/admin/dashboard";
    }

    //Product
    @Override
    @GetMapping("/products")
    public String adminProductsView(Model model) throws ProductNotFoundException {
        model.addAttribute("selected", "products");
        model.addAttribute("subSelected", "listProducts");

        return "admin/products/index";
    }

    @GetMapping("/products/category")
    @Override
    public String adminProductCategoryView(Model model) {

        model.addAttribute("selected", "products");
        model.addAttribute("subSelected", "productCategory");

        return "admin/products/category";
    }


}
