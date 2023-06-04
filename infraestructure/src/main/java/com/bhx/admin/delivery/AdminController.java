package com.bhx.admin.delivery;

import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;

public interface AdminController {
    //Index
    String adminIndex(Model model);

    //Auth
    String adminLoginForm();

    //Product
    String adminProductsView(Model model) throws ProductNotFoundException;

    String adminProductCategoryView(Model model);
}
