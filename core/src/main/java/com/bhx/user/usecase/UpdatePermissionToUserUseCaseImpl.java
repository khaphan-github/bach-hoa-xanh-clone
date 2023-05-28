package com.bhx.user.usecase;

import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.ports.PermissionRepositoryService;
import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class UpdatePermissionToUserUseCaseImpl implements UpdatePermissionToUserUseCase {
    private final AccountRepositoryService accountRepositoryService;

    private final PermissionRepositoryService permissionRepositoryService;
    @Override
    public void execute(String accountId, String permissionId) throws AccountNotFoundException, PermissionNotFoundException {

        Account accountStored = accountRepositoryService.getAccountById(accountId);
        Permission permissionStored = permissionRepositoryService.getPermissionById(permissionId);
        if (accountStored == null) {
            throw new AccountNotFoundException();
        }
        if (permissionStored == null) {
            throw new PermissionNotFoundException();
        }

        accountRepositoryService.addPermissionToAccount(accountId, permissionId);
    }
}
