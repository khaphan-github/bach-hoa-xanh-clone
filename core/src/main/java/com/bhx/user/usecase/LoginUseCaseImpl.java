package com.bhx.user.usecase;

import com.bhx.user.exception.WrongUsernameOrPasswordException;
import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import com.bhx.user.ports.CryptoService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase{
    private final AccountRepositoryService accountRepositoryService;
    private final CryptoService cryptoService;

    @Override
    public Account execute(String username, String password) throws AccountNotFoundException, WrongUsernameOrPasswordException {
        Account accountStored = accountRepositoryService.findAccountByUsername(username);
        if (accountStored == null) {
            throw new AccountNotFoundException();
        }

        Boolean isMatchPassword = cryptoService.compare(password, accountStored.getPassword());

        if (Boolean.FALSE.equals(isMatchPassword)) {
            throw new WrongUsernameOrPasswordException();
        }

        return accountStored;
    }
}
