package com.bhx.user.serviceimpl;

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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author "KhaPhan" on 29-May-23
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class CreateAccountTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRepositoryService accountRepositoryService;

    @BeforeEach
    void setup() {
        accountRepository.deleteAll();

    }

    @AfterEach
    void restore() {
        accountRepository.deleteAll();
    }

    @Test
    void createAccountTest() {
        String accountId = new ObjectId().toString();
        String username = "TestUsername";
        Account newAccount = new Account();
        newAccount.setId(accountId);
        newAccount.setUsername(username);

        accountRepositoryService.saveAccount(newAccount);
        Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
        assertTrue(accountEntity.isPresent());

        assertEquals(username, accountEntity.get().getUsername());
        assertEquals(accountId, accountEntity.get().getId());
    }
}
