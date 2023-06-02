package com.bhx.user.usecase;

import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 22-May-23
 */

@AllArgsConstructor
public class GetOneAccountUseCaseImpl implements GetOneAccountUseCase{

    private final AccountRepositoryService accountRepositoryService;
    @Override
    public Account execute(String id) throws AccountNotFoundException {
        Account accountStored = accountRepositoryService.getAccountById(id);

        if (accountStored == null) {
            throw new AccountNotFoundException();
        }

        return accountStored;
    }
}
