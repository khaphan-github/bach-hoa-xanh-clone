package com.bhx.product.delivery;

import com.bhx.map.Locate;
import com.bhx.product.exception.PagingWrongFormat;
import com.bhx.product.exception.ProductNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

public interface ProductController {

    String index(Model model) throws Exception;

    String contact(Model model);

    String indexGetLocate(@RequestBody Locate myData) throws IOException, InterruptedException, PagingWrongFormat, ProductNotFoundException;
    String shop(Model model, int page, int size) throws PagingWrongFormat, IOException, ProductNotFoundException, InterruptedException;

    String directDetails(Model model, String id) throws ProductNotFoundException;

    String directShoppingCart(Model model);

    String directCheckout(Model model);

}
