package com.bhx.admin.delivery;

import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.securityconfig.user.exception.UserNotFoundException;
import com.bhx.securityconfig.user.exception.WrongUsernameOrPasswordException;
import org.springframework.ui.Model;

public interface AdminController {
    //Index
    String adminIndex(Model model);

    //Auth
    String adminLoginForm();

    //Product
    String adminProductsView(Model model) throws ProductNotFoundException;

    String adminProductCategoryView(Model model);

    String handleLogin(String username, String password, boolean rememberMe, Model model) throws UserNotFoundException, WrongUsernameOrPasswordException;
}
