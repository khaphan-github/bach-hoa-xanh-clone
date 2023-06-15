package com.bhx.storage;

import com.bhx.storage.persistence.impl.StorageServiceImpl;
import com.bhx.storage.persistence.repositories.StorageRepository;
import com.bhx.storage.usecase.GetAllStorageUsecase;
import com.bhx.storage.usecase.GetAllStorageUsecaseImpl;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class GetAllStorageUseCaseTest {
    @Autowired
    private StorageServiceImpl storageServiceImpl;

    @Autowired
    private GetAllStorageUsecaseImpl getAllStorageUsecase;
    @Autowired
    private StorageRepository storageRepository;
    private String storageIdTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        storageIdTest = new ObjectId().toString();
    }

    @Test
    void testGetAllStorage() {
        Collection<Storage> storageCollection =  getAllStorageUsecase.excute();
        assertTrue(!storageCollection.isEmpty());
    }
}
