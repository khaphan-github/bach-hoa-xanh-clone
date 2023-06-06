package com.bhx.user.persistence.converters;

import com.bhx.global.shared.RepositoryConverter;
import com.bhx.securityconfig.user.Account;
import com.bhx.user.persistence.entities.AccountEntity;

/**
 * @author "KhaPhan" on 28-May-23
 */
public class AccountRepositoryConverter implements RepositoryConverter<AccountEntity, Account> {
    @Override
    public AccountEntity mapToTable(final Account persistenceObject) {
        return new AccountEntity(
                persistenceObject.getId(),
                persistenceObject.getUsername(),
                persistenceObject.getPassword(),
                persistenceObject.getDisplayName(),
                persistenceObject.getEmail(),
                persistenceObject.getPhone(),
                persistenceObject.getAddress(),
                persistenceObject.getPermissionId(),
                persistenceObject.getCreatedAt(),
                persistenceObject.getLastLogin(),
                persistenceObject.isActive()
        );
    }

    @Override
    public Account mapToEntity(final AccountEntity entityObject) {
        return new Account(
                entityObject.getId(),
                entityObject.getUsername(),
                entityObject.getPassword(),
                entityObject.getDisplayName(),
                entityObject.getEmail(),
                entityObject.getPhone(),
                entityObject.getAddress(),
                entityObject.getPermissionId(),
                entityObject.getCreatedAt(),
                entityObject.getLastLogin(),
                entityObject.isActive()
        );
    }
}
