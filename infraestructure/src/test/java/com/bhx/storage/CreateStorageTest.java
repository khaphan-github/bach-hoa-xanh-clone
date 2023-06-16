package com.bhx.storage;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.storage.persistence.impl.StorageServiceImpl;
import com.bhx.storage.persistence.repositories.StorageRepository;
import com.bhx.storage.usecase.CreateAStorageUseCase;
import com.bhx.storage.usecase.CreateAStorageUseCaseImpl;
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

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class CreateStorageTest {

    @Autowired
    private StorageRepository storageRepository;

    private CreateAStorageUseCaseImpl createAStorageUseCase;
    private String storageIdTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        storageIdTest = new ObjectId().toString();
    }
    private Storage getTestData() {
       Storage storage = new Storage();
       storage.setId(storageIdTest);
       storage.setAddress("Tây Ninh");
        return storage;
    }

    @Test
    void testCreateStorage() {
        Storage storage = getTestData();
        createAStorageUseCase.excute(storage);
        assertTrue(storageRepository.findById(storage.getId()).isPresent());
    }

}
