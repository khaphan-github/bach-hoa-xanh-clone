package com.bhx.user.usecase;

import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.exception.AccountAlreadyExistException;
import com.bhx.securityconfig.user.usecase.CreateAccountUseCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author "KhaPhan" on 29-May-23
 */
@Slf4j
@SpringJUnitConfig
@SpringBootTest
class CreateAccountUseCaseTest {
    @Autowired
    CreateAccountUseCase createAccountUseCase;
    @Test
    void createAccountUseCaseTest() throws AccountAlreadyExistException {
        Account account = new Account();
        account.setUsername("admin1");
        account.setPassword("admin1");
        createAccountUseCase.execute(account);
    }
}
