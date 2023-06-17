package com.bhx.user.usecase;

import com.bhx.user.Account;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 11-Jun-23
 */
public interface GetAccountByUserNameUseCase {
    Account execute(String username) throws AccountNotFoundException;
}
