package com.bhx.product.serviceimpl;

import com.bhx.category.Category;
import com.bhx.category.persistence.impl.CategoryServiceImpl;
import com.bhx.category.persistence.repositories.CategoryRepository;
import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author "KhaPhan" on 19-May-23
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class CreateProductTest {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductRepository productRepository;
    private String productIdTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productIdTest = new ObjectId().toString();
    }
    @AfterEach
    public void restore() {
        productRepository.deleteById(productIdTest);
    }

    private Product getTestData() {
        Product product = new Product();
        product.setId(productIdTest);
        product.setName("Example Product");

        product.setUpdatedDate(new Date());

        product.setAvailable(true);
        return product;
    }

    @Test
    void testCreateProduct() throws ProductNotFoundException {
        Product product = getTestData();
        productServiceImpl.saveProduct(product);
        assertTrue(productRepository.findById(product.getId()).isPresent());
    }

}
