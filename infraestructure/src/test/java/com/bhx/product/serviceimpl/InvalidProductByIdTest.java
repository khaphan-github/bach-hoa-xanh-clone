package com.bhx.product.serviceimpl;

import com.bhx.product.Product;
import com.bhx.product.persistence.entities.ProductEntity;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class InvalidProductByIdTest {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductRepository productRepository;


    private void createTestData() {

        Product product = new Product();

        product.setId(productIdTest);

        product.setName("TestProductName");

        product.setAvailable(true);

        productServiceImpl.saveProduct(product);
    }

    private final String productIdTest = new ObjectId().toString();
    @BeforeEach()
    public void setUp() {
        productRepository.deleteAll();
        createTestData();
    }

    @AfterEach()
    public void restore() {
        productRepository.deleteAll();
    }

    @Test
    void getAllProductTest() {
        productServiceImpl.inValidProductById(productIdTest);
        Optional<ProductEntity> productEntity = productRepository.findById(productIdTest);

        assertTrue(productEntity.isPresent());
        assertFalse(productEntity.get().isAvailable());
    }
}
