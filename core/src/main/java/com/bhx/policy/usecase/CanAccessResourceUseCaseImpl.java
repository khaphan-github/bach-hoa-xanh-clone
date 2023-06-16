package com.bhx.policy.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.ports.PermissionRepositoryService;
import com.bhx.policy.Credential;
import com.bhx.policy.exceptions.CanNotAccessResourceException;
import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collection;

/**
 * @author "KhaPhan" on 15-Jun-23
 */

@AllArgsConstructor
public class CanAccessResourceUseCaseImpl implements CanAccessResourceUseCase {
    private final PermissionRepositoryService permissionRepositoryService;
    private final AccountRepositoryService accountRepositoryService;

    @Override
    public boolean execute(Credential credential) throws CanNotAccessResourceException, AccountNotFoundException, PermissionNotFoundException {
        Account account = accountRepositoryService.findAccountByUsername(credential.getUsername());

        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        Permission permissions = permissionRepositoryService.getPermissionByCredential(credential);


        if (permissions == null) {
            throw new PermissionNotFoundException("Permission not found");
        }

        if (!permissions.isActive()) {
            return false;
        }

        for (String groupId : account.getGroupIds()) {
            for (String permissionGroupId : permissions.getAccessGroupIds()) {
                boolean isMatchId = permissionGroupId.equals(groupId);
                if (isMatchId) {
                    return true;
                }
            }
        }

        return false;
    }
}
