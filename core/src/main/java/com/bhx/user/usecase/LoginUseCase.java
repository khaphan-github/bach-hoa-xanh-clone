package com.bhx.user.usecase;

import com.bhx.user.Account;
import com.bhx.user.exception.WrongUsernameOrPasswordException;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
public interface LoginUseCase {
    Account execute(String username, String password) throws AccountNotFoundException, WrongUsernameOrPasswordException;
}
