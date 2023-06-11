package com.bhx.admin.delivery.impl;

import com.bhx.admin.delivery.AdminController;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetAllProductsUseCase;

import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.exception.UserNotFoundException;
import com.bhx.securityconfig.user.exception.WrongUsernameOrPasswordException;
import com.bhx.securityconfig.user.usecase.LoginUseCase;
import com.bhx.webconfig.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;

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
