package com.bhx.securityconfig.user.usecase;

import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 11-Jun-23
 */
@AllArgsConstructor
public class GetAccountByUserNameUseCaseImpl implements GetAccountByUserNameUseCase {
    private final AccountRepositoryService accountRepositoryService;
    @Override
    public Account execute(String username) throws AccountNotFoundException {
        Account account = accountRepositoryService.findAccountByUsername(username);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }
}
