package com.bhx.ProductInventory;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.usecase.GetOneProductUseCase;
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

import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;

@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class GetProductIdsByStorageIdTest {

    @Autowired
    private ProductInventoryServiceImpl productInventoryService;

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateStorage() throws ProductNotFoundException {
        List<String> id =productInventoryRepository.findProductIdsByStorageId("6486f1695228aa3d8db2bdaf");
        List<Product> product = productInventoryService.getProductByStorageId("6486f1695228aa3d8db2bdaf");
        assertTrue(true);
    }
}
