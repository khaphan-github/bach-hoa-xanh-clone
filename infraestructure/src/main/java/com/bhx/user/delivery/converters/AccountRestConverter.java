package com.bhx.user.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.permission.Permission;
import com.bhx.permission.delivery.response.PermissionView;
import com.bhx.user.Account;
import com.bhx.user.delivery.response.AccountView;

/**
 * @author "KhaPhan" on 29-May-23
 * @project clean-architecture
 */
public class AccountRestConverter implements RestConverter<AccountView, Account> {
    @Override
    public Account mapToEntity(final AccountView viewModel) {
        return new Account(

        );
    }

    @Override
    public AccountView mapToRest(final Account entity) {
        return new AccountView();
    }
}
