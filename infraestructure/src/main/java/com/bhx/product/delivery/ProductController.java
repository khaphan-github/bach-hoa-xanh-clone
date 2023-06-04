package com.bhx.product.delivery;

import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;

public interface ProductController {

    String index(Model model) throws Exception;

    String contact(Model model);

    String shop(Model model);

    String directDetails(Model model);

    String directShoppingCart(Model model);

    String directCheckout(Model model);

}
