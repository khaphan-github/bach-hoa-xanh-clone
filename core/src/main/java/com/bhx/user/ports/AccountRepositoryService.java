package com.bhx.user.ports;

import com.bhx.user.exception.WrongUsernameOrPasswordException;
import com.bhx.user.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collection;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface AccountRepositoryService {
    Collection<Account> getAllAccounts(int page, int size);
    Collection<Account> getAccountsByPermissionId(String permissionId, int page, int size);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(String id);
    Account getAccountById(String id);
    void invalidAccount(String id);
    Boolean isExistingAccountUsername(String name);
    Account login(String username, String password) throws WrongUsernameOrPasswordException;
    Account findAccountByUsername(String username) throws AccountNotFoundException;
}
