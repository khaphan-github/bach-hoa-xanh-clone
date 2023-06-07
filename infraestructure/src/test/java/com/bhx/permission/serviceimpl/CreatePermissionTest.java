package com.bhx.permission.serviceimpl;

import com.bhx.securityconfig.permission.persistence.entities.PermissionEntity;
import com.bhx.securityconfig.permission.persistence.impl.PermissionServiceImpl;
import com.bhx.securityconfig.permission.persistence.repository.PermissionRepository;
import com.bhx.securityconfig.permission.Permission;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author "KhaPhan" on 28-May-23
 * @project clean-architecture
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class CreatePermissionTest {

    @Autowired
    private PermissionServiceImpl permissionService;

    @Autowired
    private PermissionRepository permissionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void restore() {
        permissionRepository.deleteAll();
    }

    @Test
    void createPermission() {
        String permissionId = new ObjectId().toString();
        Permission permission = new Permission(permissionId, "TestName", "Desc", new Date(), new Date(), true);

        permissionService.savePermission(permission);

        Optional<PermissionEntity> permissionStored = permissionRepository.findById(permissionId);
        assertTrue(permissionStored.isPresent());
    }
}
