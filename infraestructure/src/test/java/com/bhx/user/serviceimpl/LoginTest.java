package com.bhx.user.serviceimpl;

import com.bhx.user.Account;
import com.bhx.user.exception.WrongUsernameOrPasswordException;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author "KhaPhan" on 29-May-23
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class LoginTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRepositoryService accountRepositoryService;

    private final String username = "TestUsername";
    private final String password = "TestPassword";
    @BeforeEach
    void setup() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(new ObjectId().toString());
        accountEntity.setUsername(username);
        accountEntity.setPassword(password);
        accountRepository.save(accountEntity);
    }

    @AfterEach
    void restore() {
        accountRepository.deleteAll();
    }

    @Test
    void loginTest() throws WrongUsernameOrPasswordException {
        Account accountAfterLogin = accountRepositoryService.login(username, password);
        assertNotNull(accountAfterLogin);
        assertEquals(username, accountAfterLogin.getUsername());
        assertEquals(password, accountAfterLogin.getPassword());
    }

    @Test
    void loginTestInvalidUsernameAndPassword() {
        String invalidUsername = "invalidUsername";
        String invalidPassword = "invalidPassword";

        try {
            Account accountAfterLogin = accountRepositoryService.login(invalidUsername, invalidPassword);
            fail("Expected WrongUsernameOrPasswordException to be thrown, but no exception was thrown.");
        } catch (WrongUsernameOrPasswordException e) {
            // Exception successfully thrown, test passed
        }
    }
}
