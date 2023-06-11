package com.bhx.securityconfig.user.usecase;

import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class GetAccountsPagingUseCaseImpl implements GetAccountsPagingUseCase {

    private final AccountRepositoryService accountRepositoryService;

    @Override
    public Collection<Account> execute(int page, int size) {
        return accountRepositoryService.getAllAccounts(page, size);
    }
}
