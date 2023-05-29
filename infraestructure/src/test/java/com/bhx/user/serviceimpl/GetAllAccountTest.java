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

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author "KhaPhan" on 29-May-23
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class GetAllAccountTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRepositoryService accountRepositoryService;

    private final int collectionLength = 10;

    @BeforeEach
    void setup() {
        for (int i = 0; i < collectionLength; i++) {
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setId(new ObjectId().toString());
            accountEntity.setUsername("TestUsername");

            accountRepository.save(accountEntity);
        }
    }

    @AfterEach
    void restore() {
        accountRepository.deleteAll();
    }

    @Test
    void getAllAccountTest() {
        Collection<Account> accountCollection = accountRepositoryService.getAllAccounts(0, collectionLength);
        assertFalse(accountCollection.isEmpty());
        assertEquals(accountCollection.size(), collectionLength);
    }

    @Test
    void getAllAccountPageHalf() {
        Collection<Account> accountCollection = accountRepositoryService.getAllAccounts(0, collectionLength/2);
        assertFalse(accountCollection.isEmpty());
        assertEquals(collectionLength/2, accountCollection.size());
    }
}
