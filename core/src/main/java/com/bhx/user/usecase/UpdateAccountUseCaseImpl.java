package com.bhx.user.usecase;

import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import com.bhx.user.ports.CryptoService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class UpdateAccountUseCaseImpl implements UpdateAccountUseCase{

    private final AccountRepositoryService accountRepositoryService;
    private final CryptoService cryptoService;

    @Override
    public void execute(Account account) throws AccountNotFoundException {

        Account accountStored = accountRepositoryService.getAccountById(account.getId());

        if (accountStored == null) {
            throw new AccountNotFoundException("Account not found");
        }

        if (account.getPassword() == null || account.getPassword().equals("")) {
            account.setPassword(accountStored.getPassword());
        } else  {
            String passwordHash = cryptoService.encode(account.getPassword());
            account.setPassword(passwordHash);
        }

        accountRepositoryService.updateAccount(account);
    }
}
