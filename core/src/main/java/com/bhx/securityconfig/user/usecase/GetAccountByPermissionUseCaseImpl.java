package com.bhx.securityconfig.user.usecase;

import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class GetAccountByPermissionUseCaseImpl implements GetAccountByPermissionUseCase {

    private final AccountRepositoryService accountRepositoryService;

    @Override
    public Collection<Account> execute(String permissionId, int page, int size) {
        return accountRepositoryService.getAccountsByPermissionId(permissionId, page, size);
    }
}
