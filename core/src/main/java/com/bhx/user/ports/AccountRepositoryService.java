package com.bhx.user.ports;

import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.user.Account;
import com.bhx.user.exception.WrongUsernameOrPasswordException;

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
    void addPermissionToAccount(String accountId, String permissionId) throws PermissionNotFoundException, AccountNotFoundException;
    Account login(String username, String password) throws WrongUsernameOrPasswordException;

    Account findAccountByUsername(String username);
}