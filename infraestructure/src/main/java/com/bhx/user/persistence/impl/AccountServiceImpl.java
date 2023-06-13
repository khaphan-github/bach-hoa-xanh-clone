package com.bhx.user.persistence.impl;

import com.bhx.securityconfig.group.persistence.repository.GroupRepository;
import com.bhx.securityconfig.permission.exception.PermissionNotFoundException;
import com.bhx.securityconfig.permission.persistence.entities.PermissionEntity;
import com.bhx.securityconfig.permission.persistence.repository.PermissionRepository;
import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.exception.WrongUsernameOrPasswordException;
import com.bhx.user.persistence.converters.AccountRepositoryConverter;
import com.bhx.user.persistence.entities.AccountEntity;
import com.bhx.user.persistence.repository.AccountRepository;
import com.bhx.securityconfig.user.ports.AccountRepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author "KhaPhan" on 28-May-23
 */
@AllArgsConstructor
public class AccountServiceImpl implements AccountRepositoryService {
    private final AccountRepository accountRepository;
    private final GroupRepository groupRepository;
    private final AccountRepositoryConverter accountRepositoryConverter;


    @Override
    public Collection<Account> getAllAccounts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AccountEntity> accountEntityPage = accountRepository.findAll(pageable);
        return accountEntityPage.stream().map(accountRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<Account> getAccountsByPermissionId(String permissionId, int page, int size) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(accountRepositoryConverter.mapToTable(account));
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(String id) {

    }

    @Override
    public Account getAccountById(String id) {
        return null;
    }

    @Override
    public void invalidAccount(String id) {

    }

    @Override
    public Boolean isExistingAccountUsername(String name) {
        return null;
    }

    @Override
    public Account login(String username, String password) throws WrongUsernameOrPasswordException {
        Optional<AccountEntity> accountEntity = accountRepository.findByUsername(username);


        boolean isRightPassword = accountEntity.isPresent() && accountEntity.get().getPassword().equals(password);
        if (isRightPassword) {
            return accountRepositoryConverter.mapToEntity(accountEntity.get());
        } else {
            throw new WrongUsernameOrPasswordException();
        }
    }

    @Override
    public Account findAccountByUsername(String username) throws AccountNotFoundException {
        Optional<AccountEntity> accountEntity = accountRepository.findByUsername(username);
        if (accountEntity.isPresent()) {
            return accountRepositoryConverter.mapToEntity(accountEntity.get());
        }
        throw new AccountNotFoundException("Account not found");
    }
}
