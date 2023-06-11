package com.bhx.securityconfig.user.usecase;

import com.bhx.securityconfig.user.Account;

import java.util.Collection;

/**
 * @author "KhaPhan" on 08-Jun-23
 * @project clean-architecture
 */
public interface GetAccountsPagingUseCase {
    Collection<Account> execute(int page, int size);
}
