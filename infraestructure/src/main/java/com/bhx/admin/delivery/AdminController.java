package com.bhx.admin.delivery;

import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;

public interface AdminController {
    String adminIndex(Model model);

    String adminLoginForm();
    String adminProductsView(Model model) throws ProductNotFoundException;
}
