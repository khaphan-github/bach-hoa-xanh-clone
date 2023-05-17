package com.bhx.product.delivery;

import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;

public interface ProductController {

    String index(Model model) throws ProductNotFoundException;

    String contact(Model model);

    String shop(Model model);

    String direct_detail(Model model);

    String direct_shopping_cart(Model model);

    String direct_checkout(Model model);
}
