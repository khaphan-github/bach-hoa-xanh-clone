package com.bhx.group.usecase;

import com.bhx.group.exceptions.UserAlreadyInGroupException;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.user.Account;
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
