package com.bhx.user.usecase;

import com.bhx.group.exceptions.GroupNotFoundException;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.user.Account;
import com.bhx.user.exception.AccountAlreadyExistException;
import com.bhx.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author "KhaPhan" on 14-Jun-23
 */
@AllArgsConstructor
public class CreateAccountWithGroupUseCaseImpl implements CreateAccountWithGroupUseCase {
    private final AccountRepositoryService accountRepositoryService;
    private final GroupRepositoryService groupRepositoryService;
    @Override
    public void execute(Account account, List<String> groupIds) throws AccountAlreadyExistException, GroupNotFoundException {
        try {

            account.setGroupIds(groupIds);
            accountRepositoryService.saveAccount(account);

        } catch (Exception ex) {

        }
    }
}
