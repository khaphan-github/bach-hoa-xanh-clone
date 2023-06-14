package com.bhx.ProductInventory;

import com.bhx.productInventory.ProductInventory;
import com.bhx.productInventory.persistence.impl.ProductInventoryServiceImpl;
import com.bhx.productInventory.persistence.repositories.ProductInventoryRepository;
import com.bhx.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;

@Slf4j
@SpringJUnitConfig
@SpringBootTest

public class ProductInventoryTest {
    @Autowired
    private ProductInventoryServiceImpl productInventoryService;

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    private ProductInventory getTestData() {
        ProductInventory productInventory = new ProductInventory();
        productInventory.setInventory(21);
        productInventory.setProductId("2");
        productInventory.setStorageId("12");
        return productInventory;
    }

    @Test
    void testCreateStorage() {
        ProductInventory productInventory = getTestData();
        productInventoryService.saveProductInventory(productInventory);
        assertTrue(productInventoryRepository.findById(productInventory.getProductId()).isPresent());
    }


}
