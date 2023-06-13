package com.bhx.user.persistence.converters;

import com.bhx.global.shared.RepositoryConverter;
import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.user.Account;
import com.bhx.user.persistence.entities.AccountEntity;
import com.mongodb.client.model.Collation;

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
                persistenceObject.getCreatedAt(),
                persistenceObject.getLastLogin(),
                persistenceObject.isActive()
        );
    }

    @Override
    public Account mapToEntity(final AccountEntity entityObject) {
        Account account = new Account();

        account.setId(entityObject.getId());
        account.setUsername(entityObject.getUsername());
        account.setPassword(entityObject.getPassword());

        account.setDisplayName(entityObject.getDisplayName());
        account.setEmail(entityObject.getEmail());
        account.setPhone(entityObject.getPhone());
        account.setAddress(entityObject.getAddress());
        account.setCreatedAt(entityObject.getCreatedAt());
        account.setLastLogin(entityObject.getLastLogin());
        account.setActive(entityObject.isActive());
        return account;
    }
}
