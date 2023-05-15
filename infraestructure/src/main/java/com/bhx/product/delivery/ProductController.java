package com.bhx.product.delivery;

import org.springframework.ui.Model;

public interface ProductController {

    String index(Model model);

    String contact(Model model);

    String shop(Model model);

    String direct_detail(Model model);

    String direct_shopping_cart(Model model);

    String direct_checkout(Model model);
}
