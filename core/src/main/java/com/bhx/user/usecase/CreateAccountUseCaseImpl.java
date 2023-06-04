package com.bhx.user.usecase;

import com.bhx.user.Account;
import com.bhx.user.exception.AccountAlreadyExistException;
import com.bhx.user.ports.AccountRepositoryService;
import com.bhx.user.ports.CryptoService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 20-May-23
 */
@AllArgsConstructor
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {

    private final AccountRepositoryService accountRepositoryService;
    private final CryptoService cryptoService;

    @Override
    public void execute(Account account) throws AccountAlreadyExistException {
        Boolean isExistAccount = accountRepositoryService.isExistingAccountUsername(account.getUsername());
        if (Boolean.TRUE.equals(isExistAccount)) {
            throw new AccountAlreadyExistException();
        }
        String passwordHash = cryptoService.encode(account.getPassword());
        account.setPassword(passwordHash);

        accountRepositoryService.saveAccount(account);
    }
}
