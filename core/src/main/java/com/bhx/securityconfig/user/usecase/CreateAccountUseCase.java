package com.bhx.securityconfig.user.usecase;

import com.bhx.securityconfig.user.exception.AccountAlreadyExistException;
import com.bhx.securityconfig.user.Account;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface CreateAccountUseCase {
    void execute(Account account) throws AccountAlreadyExistException;
}
