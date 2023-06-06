package com.bhx.securityconfig.user.usecase;

import com.bhx.securityconfig.user.exception.WrongUsernameOrPasswordException;
import com.bhx.securityconfig.user.Account;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
public interface LoginUseCase {
    Account execute(String username, String password) throws AccountNotFoundException, WrongUsernameOrPasswordException;
}
