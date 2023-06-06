package com.bhx.user.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.securityconfig.user.Account;
import com.bhx.user.delivery.response.AccountView;

/**
 * @author "KhaPhan" on 29-May-23
 * @project clean-architecture
 */
public class AccountRestConverter implements RestConverter<AccountView, Account> {
    @Override
    public Account mapToEntity(final AccountView viewModel) {
        return new Account(
                viewModel.getId(),
                viewModel.getUsername(),
                viewModel.getEmail(),
                viewModel.getPhone(),
                viewModel.getAddress(),
                viewModel.getPermissionName(),
                viewModel.getCreatedAt(),
                viewModel.getLastLogin(),
                viewModel.isActive()
        );
    }

    @Override
    public AccountView mapToRest(final Account entity) {
        return new AccountView(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress(),
                entity.getPermissionId(),
                entity.getCreatedAt(),
                entity.getLastLogin(),
                entity.isActive());
    }
}
