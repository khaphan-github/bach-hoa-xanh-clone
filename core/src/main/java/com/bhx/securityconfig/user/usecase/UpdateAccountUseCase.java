package com.bhx.securityconfig.user.usecase;

import com.bhx.securityconfig.user.Account;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface UpdateAccountUseCase {
    void execute(Account account) throws AccountNotFoundException;
}
