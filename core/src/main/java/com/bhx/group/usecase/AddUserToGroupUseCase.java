package com.bhx.group.usecase;

import com.bhx.group.exceptions.UserAlreadyInGroupException;
import com.bhx.user.Account;

import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface AddUserToGroupUseCase {
    void execute(List<Account> accounts, String groupId) throws UserAlreadyInGroupException;
}
