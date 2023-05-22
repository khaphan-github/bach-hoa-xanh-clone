package com.bhx.user.usecase;

import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class UpdateAccountUseCaseImpl implements UpdateAccountUseCase{

    private final AccountRepositoryService accountRepositoryService;
    @Override
    public void execute(Account account) throws AccountNotFoundException {
        Account accountStored = accountRepositoryService.getAccountById(account.getId());

        if (accountStored == null) {
            throw new AccountNotFoundException();
        }

        accountRepositoryService.updateAccount(account);
    }
}
