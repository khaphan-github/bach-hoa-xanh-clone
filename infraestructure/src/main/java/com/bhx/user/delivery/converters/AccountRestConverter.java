package com.bhx.user.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.user.Account;
import com.bhx.user.delivery.response.AccountView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author "KhaPhan" on 29-May-23
 * @project clean-architecture
 */
public class AccountRestConverter implements RestConverter<AccountView, Account> {
    @Override
    public Account mapToEntity(final AccountView viewModel) {
        return new Account();
    }

    @Override
    public AccountView mapToRest(final Account entity) {
        AccountView accountView = new AccountView();
        accountView.setId(entity.getId());
        accountView.setUsername(entity.getUsername());
        accountView.setEmail(entity.getEmail());
        accountView.setPhone(entity.getPhone());
        accountView.setAddress(entity.getAddress());

        Collection<String> groupNames = new ArrayList<>();
        for (Group group : entity.getGroup()) {
            groupNames.add(group.getName());
        }
        accountView.setGroupName(groupNames);

        accountView.setCreatedAt(entity.getCreatedAt());
        accountView.setLastLogin(entity.getLastLogin());
        accountView.setActive(entity.isActive());

        return accountView;
    }
}
