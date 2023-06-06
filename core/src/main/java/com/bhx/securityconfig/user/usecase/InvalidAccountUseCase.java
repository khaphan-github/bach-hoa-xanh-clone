package com.bhx.securityconfig.user.usecase;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface InvalidAccountUseCase {
    void execute(String id) throws AccountNotFoundException;
}
