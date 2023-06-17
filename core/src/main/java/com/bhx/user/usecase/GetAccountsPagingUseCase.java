package com.bhx.user.usecase;

import com.bhx.user.Account;

import java.util.Collection;

/**
 * @author "KhaPhan" on 08-Jun-23
 * @project clean-architecture
 */
public interface GetAccountsPagingUseCase {
    Collection<Account> execute(int page, int size);
}
