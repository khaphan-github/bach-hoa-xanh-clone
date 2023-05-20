package com.bhx.product.serviceimpl;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class GetProductById {

    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductRepository productRepository;

    private void createTestData(String id) {

        Product product = new Product();

        product.setId(id);

        product.setName("TestProductName");

        product.setAvailable(true);

        productServiceImpl.saveProduct(product);
    }

    private final String productId = new ObjectId().toString();
    @BeforeEach()
    public void setUp() {
        createTestData(productId);
    }

    @AfterEach()
    public void restore() {
        productRepository.deleteById(productId);
    }

    @Test
    void getAllProductTest() throws ProductNotFoundException {
        Product products = productServiceImpl.getProductById(productId);
        assertEquals(productId, products.getId());
    }
}
