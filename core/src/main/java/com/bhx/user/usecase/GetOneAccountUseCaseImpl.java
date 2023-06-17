package com.bhx.user.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collection;

/**
 * @author "KhaPhan" on 22-May-23
 */

@AllArgsConstructor
public class GetOneAccountUseCaseImpl implements GetOneAccountUseCase {

    private final AccountRepositoryService accountRepositoryService;
    private final GroupRepositoryService groupRepositoryService;

    @Override
    public Account execute(String id) throws AccountNotFoundException {
        Account accountStored = accountRepositoryService.getAccountById(id);

        if (accountStored == null) {
            throw new AccountNotFoundException();
        }

        Collection<Group> groups = groupRepositoryService.getGroups();

        accountStored.setGroup(groups);

        return accountStored;
    }
}
