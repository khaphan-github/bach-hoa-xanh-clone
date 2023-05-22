package com.bhx.product.serviceimpl;

import com.bhx.category.Category;
import com.bhx.category.persistence.impl.CategoryServiceImpl;
import com.bhx.category.persistence.repositories.CategoryRepository;
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
public class GetProductByCategoryIdTest {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryServiceImpl categoryService;
    private void createTestData(String categoryId) {

        Product product = new Product();

        product.setId(new ObjectId().toString());

        product.setName("TestProductName");
        product.setCategoryId(categoryId);

        product.setAvailable(true);

        productServiceImpl.saveProduct(product);
    }

    private final int maxSize = 20;
    private final String categoryId = new ObjectId().toString();
    @BeforeEach()
    public void setUp() {
        productRepository.deleteAll();

        Category category = new Category(categoryId, categoryId, "TestCategory", true);
        categoryService.saveCategory(category);

        for (int i = 0; i < maxSize; i++) {
            createTestData(categoryId);
        }

        for (int i = 0; i < maxSize; i++) {
            createTestData("OtherCategoryId");
        }

    }

    @AfterEach()
    public void restore() {
        productRepository.deleteAll();
        categoryRepository.deleteById(categoryId);
    }

    @Test
    void getProductByCategoryIdTest() {
        Collection<Product> products = productServiceImpl.getProductByCategoryId(categoryId);
        assertFalse(products.isEmpty());
        assertEquals(products.size(), maxSize);
    }
}
