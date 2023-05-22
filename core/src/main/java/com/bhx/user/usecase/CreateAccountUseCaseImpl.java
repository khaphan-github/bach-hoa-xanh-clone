package com.bhx.user.usecase;

import com.bhx.user.Account;
import com.bhx.user.exception.AccountAlreadyExistException;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
public class CreateAccountUseCaseImpl implements CreateAccountUseCase{
    @Override
    public void execute(Account account) throws AccountAlreadyExistException {

    }
}
