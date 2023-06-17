package com.bhx.admin.delivery;

import com.bhx.admin.delivery.converters.ProductForm;
import com.bhx.product.exception.ProductAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdminControllerApi {

    public ResponseEntity<String> createNewProduct(ProductForm productForm);

    public ResponseEntity<List<ProductForm>> uploadProduct(List<ProductForm> productForm) throws ProductAlreadyExistException;
}
