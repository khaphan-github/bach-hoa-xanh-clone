package com.bhx.permission.serviceimpl;

import com.bhx.permission.persistence.entities.PermissionEntity;
import com.bhx.permission.persistence.impl.PermissionServiceImpl;
import com.bhx.permission.persistence.repository.PermissionRepository;
import com.bhx.permission.Permission;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author "KhaPhan" on 28-May-23
 * @project clean-architecture
 */
@SpringJUnitConfig
@Service
@SpringBootTest
class GetAllPermissionTest {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PermissionServiceImpl permissionService;

    private final int permissionCollectionSize = 10;

    @BeforeEach
    void setup() {
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
    void getAllPermissionTest() {
        Collection<Permission> permissionCollectionStored = permissionService.getAllPermission();

        assertFalse(permissionCollectionStored.isEmpty());
        assertEquals(permissionCollectionSize, permissionCollectionStored.size());
    }

}
