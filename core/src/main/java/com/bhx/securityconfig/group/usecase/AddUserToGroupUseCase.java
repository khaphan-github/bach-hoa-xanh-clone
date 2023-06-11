package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.exceptions.UserAlreadyInGroupException;
import com.bhx.securityconfig.user.Account;

import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface AddUserToGroupUseCase {
    void execute(List<Account> accounts, String groupId) throws UserAlreadyInGroupException;
}
