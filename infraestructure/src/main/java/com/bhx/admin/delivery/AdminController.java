package com.bhx.admin.delivery;

import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.user.exception.UserNotFoundException;
import com.bhx.user.exception.WrongUsernameOrPasswordException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminController {
    //Index
    String adminIndex(Model model);

    //Auth
    String adminLoginFormView();

    String adminLoginForm(@RequestParam("username") String username, @RequestParam("password") String password);

    //Product
    String adminProductsView(Model model) throws ProductNotFoundException;

    String adminProductCategoryView(Model model);

    String handleLogin(String username, String password, boolean rememberMe, Model model) throws UserNotFoundException, WrongUsernameOrPasswordException;
}
