package com.bhx.product.delivery;

import com.bhx.map.Locate;
import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductController {

    String index(Model model) throws Exception;

    String contact(Model model);

    String indexGetLocate(@RequestBody Locate myData);
    String shop(Model model);

    String directDetails(Model model);

    String directShoppingCart(Model model);

    String directCheckout(Model model);

}
