package com.bhx.product.delivery.impl;

import com.bhx.category.Category;
import com.bhx.category.usecase.CreateCategoryUseCase;
import com.bhx.map.Locate;
import com.bhx.map.usecase.GetNearestAddressByUserLocateUseCase;
import com.bhx.product.Product;
import com.bhx.product.delivery.ProductController;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.exception.PagingWrongFormat;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.ports.ProductRepositoryService;
import com.bhx.product.usecase.GetAllProductsUseCase;
import com.bhx.productInventory.usecase.GetAllProductByUserLocateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Collection;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final ProductMvcConverter productMvcConverter;
    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetNearestAddressByUserLocateUseCase getNearestAddressByUserLocateUseCase;
    private final GetAllProductByUserLocateUseCase getAllProductByUserLocateUseCase;
    private final ProductRepositoryService productRepositoryService;

    private Collection<Product> products;
    private String longitude;
    private String latitude;

    @Override
    @GetMapping({"/", "/index"})
    public String index(Model model) throws Exception {
        model.addAttribute("active","home");
        model.addAttribute("products", products);
        return "public/home/index";
    }

    @Override
    @PostMapping({"/", "/index"})
    public String indexGetLocate(Locate myData) throws IOException, InterruptedException, PagingWrongFormat, ProductNotFoundException {
        latitude = myData.getLatitude();
        longitude = myData.getLongitude();
        String nearest =getNearestAddressByUserLocateUseCase.excute(Double.parseDouble(longitude), Double.parseDouble(latitude));
        products= getAllProductByUserLocateUseCase.excute(0, 10,Double.parseDouble(longitude), Double.parseDouble(latitude));
        return "public/home/index";
    }

    @Override
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("active","contact");

        return "public/contact/index";
    }



    @Override
    @GetMapping("/shop")
    public String shop(Model model, @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "6") int size) throws PagingWrongFormat, IOException, ProductNotFoundException, InterruptedException {
        model.addAttribute("active","shop");
        products= getAllProductByUserLocateUseCase.excute(page, size,Double.parseDouble(longitude), Double.parseDouble(latitude));
        model.addAttribute("productsList", products);
        return "public/shop/index";
    }

    @GetMapping("/direct/details")
    public String directDetails(Model model, @RequestParam("id") String id) throws ProductNotFoundException {
        model.addAttribute("active", "direct");

        Product productDetail = productRepositoryService.getProductById(id);
        model.addAttribute("product", productDetail);
        return "public/direct/details";
    }
    @Override
    @GetMapping("/direct/shopping_cart")
    public String directShoppingCart(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/shopping_cart";
    }

    @Override
    @GetMapping("/direct/checkout")
    public String directCheckout(Model model) {
        model.addAttribute("active","direct");
        return "public/direct/checkout";
    }
}
