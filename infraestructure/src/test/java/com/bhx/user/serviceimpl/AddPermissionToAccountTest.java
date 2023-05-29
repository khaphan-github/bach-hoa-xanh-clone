package com.bhx.user.serviceimpl;

import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.persistence.entities.PermissionEntity;
import com.bhx.permission.persistence.repository.PermissionRepository;
import com.bhx.user.Account;
import com.bhx.user.persistence.entities.AccountEntity;
import com.bhx.user.persistence.repository.AccountRepository;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author "KhaPhan" on 29-May-23
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class AddPermissionToAccountTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private AccountRepositoryService accountRepositoryService;

    private final String permissionId = new ObjectId().toString();
    private final String accountId = new ObjectId().toString();

    @BeforeEach
    void setup() {
        PermissionEntity permission = new PermissionEntity(permissionId, "TestPermission", "Desc", new Date(), new Date(), true);
        permissionRepository.save(permission);

        String username = "TestUsername";
        AccountEntity newAccount = new AccountEntity();
        newAccount.setId(accountId);
        newAccount.setUsername(username);
        accountRepository.save(newAccount);
    }

    @AfterEach
    void restore() {
        accountRepository.deleteAll();
        permissionRepository.deleteAll();
    }

    @Test
    void addPermissionToAccountTest() throws PermissionNotFoundException, AccountNotFoundException {
        accountRepositoryService.addPermissionToAccount(accountId, permissionId);

        Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
        assertTrue(accountEntity.isPresent());

        assertEquals(permissionId, accountEntity.get().getPermissionId());
    }
}
