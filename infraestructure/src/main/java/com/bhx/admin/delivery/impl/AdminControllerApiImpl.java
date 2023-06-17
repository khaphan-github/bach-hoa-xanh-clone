package com.bhx.admin.delivery.impl;

import com.bhx.admin.delivery.AdminControllerApi;
import com.bhx.admin.delivery.converters.ProductForm;
import com.bhx.product.Product;
import com.bhx.product.exception.ProductAlreadyExistException;
import com.bhx.product.usecase.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/admin/product/api")
@RequiredArgsConstructor
public class AdminControllerApiImpl implements AdminControllerApi {

    private final CreateProductUseCase createProductUseCase;
    @PostMapping("/createProduct")
    @Override
    public ResponseEntity<String> createNewProduct(@RequestBody ProductForm productForm) {
        return ResponseEntity.ok(productForm.toString());
    }

    @PostMapping("/uploadProduct")
    @Override
    public ResponseEntity<List<ProductForm>> uploadProduct(@RequestBody List<ProductForm> productForm) throws ProductAlreadyExistException {
        List<ProductForm> fail = new ArrayList<>();
        for (ProductForm product: productForm) {
            try {
                List<String> descriptionImages = Arrays.asList(product.getDescriptionImages().split(";"));
                Product newProduct = new Product(product.getName(),
                        product.getDescription(),descriptionImages,
                        product.getOutDate(),product.getPrice(),
                        product.getDiscount(),
                        product.getQuantity(),
                        product.getProductCategoryId());

                createProductUseCase.execute(newProduct);
            }

            catch (Exception ex){
                fail.add(product);
            };
        }

        return ResponseEntity.ok(fail);
    }
}
