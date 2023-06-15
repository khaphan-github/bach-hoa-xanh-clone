package com.bhx.user.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.user.Account;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class GetAccountsPagingUseCaseImpl implements GetAccountsPagingUseCase {

    private final AccountRepositoryService accountRepositoryService;
    private final GroupRepositoryService groupRepositoryService;

    @Override
    public Collection<Account> execute(int page, int size) {
        Collection<Account> accounts = accountRepositoryService.getAllAccounts(page, size);
        for (Account account : accounts) {
            Collection<Group> accountsGroups = groupRepositoryService.getGroupsByGroupIds(account.getGroupIds());
            account.setGroup(accountsGroups);
        }
        return accounts;
    }
}
