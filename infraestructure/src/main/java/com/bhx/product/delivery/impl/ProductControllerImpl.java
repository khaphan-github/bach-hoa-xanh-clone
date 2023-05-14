package com.bhx.product.delivery.impl;
import com.bhx.product.delivery.ProductController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class ProductControllerImpl implements ProductController {
    @Override
    @GetMapping
    public String index()  {
        return "index";
    }
}
