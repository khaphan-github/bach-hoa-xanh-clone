package com.bhx.user.usecase;

import com.bhx.user.exception.AccountAlreadyExistException;
import com.bhx.user.Account;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface CreateAccountUseCase {
    void execute(Account account) throws AccountAlreadyExistException;
}
