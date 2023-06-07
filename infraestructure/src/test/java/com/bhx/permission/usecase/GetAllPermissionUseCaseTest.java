package com.bhx.permission.usecase;

import com.bhx.securityconfig.permission.persistence.entities.PermissionEntity;
import com.bhx.securityconfig.permission.persistence.repository.PermissionRepository;
import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.permission.usecase.GetAllPermissionUseCase;
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
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author "KhaPhan" on 28-May-23
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class GetAllPermissionUseCaseTest {

    @Autowired
    private GetAllPermissionUseCase getAllPermissionUseCase;

    @Autowired
    private PermissionRepository permissionRepository;

    private final int permissionCollectionSize = 10;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        List<PermissionEntity> permisionEntityList = new ArrayList<>();
        for (int i = 0; i < permissionCollectionSize; i++) {
            permisionEntityList.add(new PermissionEntity(new ObjectId().toString(), "TestName", "Desc", new Date(), new Date(), true));
        }
        permissionRepository.saveAll(permisionEntityList);
    }

    @AfterEach
    void restore() {
        permissionRepository.deleteAll();
    }

    @Test
    void getAllPermissionUseCaseTest() {
        Collection<Permission> permissionCollectionStored = getAllPermissionUseCase.execute();

        assertFalse(permissionCollectionStored.isEmpty());
        assertEquals(permissionCollectionSize, permissionCollectionStored.size());
    }
}
