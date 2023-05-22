package com.bhx.product.serviceimpl;

import com.bhx.product.Product;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class ExistProductByNameTest {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductRepository productRepository;

    private void createTestData() {

        Product product = new Product();

        product.setId(new ObjectId().toString());

        product.setName(testProductName);

        product.setAvailable(true);

        productServiceImpl.saveProduct(product);
    }

    private final String testProductName = "TestProductName";
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
        boolean isExistProductByName = productServiceImpl.isExistProductByName(testProductName);
        assertTrue(isExistProductByName);
    }
}
