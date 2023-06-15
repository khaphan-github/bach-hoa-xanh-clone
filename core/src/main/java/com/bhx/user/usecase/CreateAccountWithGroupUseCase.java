package com.bhx.user.usecase;

import com.bhx.group.exceptions.GroupNotFoundException;
import com.bhx.user.Account;
import com.bhx.user.exception.AccountAlreadyExistException;

import java.util.List;

/**
 * @author "KhaPhan" on 14-Jun-23
 * @project clean-architecture
 */
public interface CreateAccountWithGroupUseCase {
    void execute(Account account, List<String> groupIds) throws AccountAlreadyExistException, GroupNotFoundException;
}
