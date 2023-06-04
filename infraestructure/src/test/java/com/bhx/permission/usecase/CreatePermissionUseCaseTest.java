package com.bhx.permission.usecase;

import com.bhx.permission.persistence.entities.PermissionEntity;
import com.bhx.permission.persistence.repository.PermissionRepository;
import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionAlreadyExist;
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
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class CreatePermissionUseCaseTest {

    @Autowired
    private CreatePermissionUseCase createPermissionUseCase;

    @Autowired
    private PermissionRepository permissionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void restore() {
        permissionRepository.deleteAll();
    }

    @Test
    void createPermissionUseCaseTest() throws PermissionAlreadyExist {
        String permissionId = new ObjectId().toString();
        Permission permission = new Permission(permissionId, "TestName", "Desc", new Date(), new Date(), true);

        createPermissionUseCase.execute(permission);


        Optional<PermissionEntity> permissionStored = permissionRepository.findById(permissionId);
        assertTrue(permissionStored.isPresent());
    }
}
