package com.bhx.user.usecase;

import com.bhx.permission.exception.PermissionNotFoundException;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface UpdatePermissionToUserUseCase {
    void execute(String accountId, String permissionId) throws AccountNotFoundException, PermissionNotFoundException;
}
