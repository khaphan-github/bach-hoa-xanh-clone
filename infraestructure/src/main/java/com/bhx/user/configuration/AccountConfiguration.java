package com.bhx.user.configuration;

import com.bhx.securityconfig.permission.persistence.impl.PermissionServiceImpl;
import com.bhx.securityconfig.permission.persistence.repository.PermissionRepository;
import com.bhx.securityconfig.user.usecase.*;
import com.bhx.user.delivery.converters.AccountRestConverter;
import com.bhx.user.persistence.converters.AccountRepositoryConverter;
import com.bhx.user.persistence.impl.AccountServiceImpl;
import com.bhx.user.persistence.impl.CryptoServiceImpl;
import com.bhx.user.persistence.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "KhaPhan" on 29-May-23
 */

@Configuration
public class AccountConfiguration {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionServiceImpl permissionService;

    @Autowired
    private CryptoServiceImpl cryptoService;

    @Bean
    public AccountRepositoryConverter accountRepositoryConverter() {
        return new AccountRepositoryConverter();
    }

    @Bean
    public AccountRestConverter accountRestConverter() {
        return new AccountRestConverter();
    }

    @Bean
    public AccountServiceImpl accountService() {
        return new AccountServiceImpl(accountRepository, permissionRepository, accountRepositoryConverter());
    }


    @Bean
    public CreateAccountUseCaseImpl createAccountUseCase() {
        return new CreateAccountUseCaseImpl(accountService(), cryptoService);
    }

    @Bean
    public GetAccountByPermissionUseCaseImpl getAccountByPermissionUseCase() {
        return new GetAccountByPermissionUseCaseImpl(accountService());
    }

    @Bean
    public GetAccountsPagingUseCaseImpl getAccountsPagingUseCase() {
        return new GetAccountsPagingUseCaseImpl(accountService());
    }

    @Bean
    public GetOneAccountUseCaseImpl getOneAccountUseCase() {
        return new GetOneAccountUseCaseImpl(accountService());
    }

    @Bean
    public InvalidAccountUseCaseImpl invalidAccountUseCase() {
        return new InvalidAccountUseCaseImpl(accountService());
    }

    @Bean
    public LoginUseCaseImpl loginUseCase() {
        return new LoginUseCaseImpl(accountService(), cryptoService);
    }

    @Bean
    public UpdateAccountUseCaseImpl updateAccountUseCase() {
        return new UpdateAccountUseCaseImpl(accountService());
    }

    @Bean
    public GetAccountByUserNameUseCaseImpl getAccountByUserNameUseCase() {
        return new GetAccountByUserNameUseCaseImpl(accountService());
    }
}
