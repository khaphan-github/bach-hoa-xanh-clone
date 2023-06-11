package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.exceptions.UserAlreadyInGroupException;
import com.bhx.securityconfig.group.ports.GroupRepositoryService;
import com.bhx.securityconfig.user.Account;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class AddUserToGroupUseCaseImpl implements AddUserToGroupUseCase {
    private final GroupRepositoryService groupRepositoryService;

    @Override
    public void execute(List<Account> accounts, String groupId) throws UserAlreadyInGroupException {
        groupRepositoryService.addAccountsToGroup(groupId, accounts);
    }
}
