package com.bhx.user.usecase;

import com.bhx.user.Account;

import java.util.Collection;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface GetAccountByPermissionUseCase {
    Collection<Account> execute(String permissionId, int page, int size);
}
