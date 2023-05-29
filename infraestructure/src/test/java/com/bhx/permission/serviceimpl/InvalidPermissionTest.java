package com.bhx.permission.serviceimpl;

import com.bhx.permission.persistence.converters.PermissionRepositoryConverter;
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

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author "KhaPhan" on 28-May-23
 */
@SpringJUnitConfig
@Service
@SpringBootTest
class InvalidPermissionTest {
    @Autowired
    private PermissionServiceImpl permissionService;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionRepositoryConverter permissionRepositoryConverter;

    private final String permissionId = new ObjectId().toString();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        boolean active = true;
        Permission permission = new Permission(permissionId, "TestName", "Desc", new Date(), new Date(), active);
        permissionRepository.save(permissionRepositoryConverter.mapToTable(permission));
    }

    @AfterEach
    public void restore() {
        permissionRepository.deleteAll();
    }

    @Test
    void invalidPermission() {
        permissionService.invalidPermission(permissionId);

        Optional<PermissionEntity> permissionStored = permissionRepository.findById(permissionId);
        assertTrue(permissionStored.isPresent());

        assertFalse(permissionStored.get().isActive());
    }
}