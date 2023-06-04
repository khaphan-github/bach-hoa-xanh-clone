package com.bhx.product.serviceimpl;

import com.bhx.product.Product;
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

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class GetAllProductPagingTest {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductRepository productRepository;
    private void getTestData(String productId) {

        Product product = new Product();

        product.setId(productId);

        product.setName("TestProductName");

        product.setAvailable(true);

        productServiceImpl.saveProduct(product);
    }

    @BeforeEach()
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        int maxSize = 20;
        for (int i = 0; i < maxSize; i++) {
            getTestData(new ObjectId().toString());
        }
    }
    @AfterEach()
    public void restore() {
        productRepository.deleteAll();
    }
    @Test
    void getProductWithPagingTestPage1() {
        int size = 10;
        Collection<Product> products = productServiceImpl.getProductsPaging(0, size);
        assertFalse(products.isEmpty());
        assertEquals(products.size(), size);
    }

    @Test
    void getProductWithPagingTestPage2() {
        int size = 10;
        Collection<Product> products = productServiceImpl.getProductsPaging(1, size);
        assertFalse(products.isEmpty());
        assertEquals(products.size(), size);
    }
}
