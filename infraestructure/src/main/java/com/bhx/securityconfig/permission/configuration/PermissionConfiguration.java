package com.bhx.securityconfig.permission.configuration;

import com.bhx.securityconfig.permission.persistence.converters.PermissionRepositoryConverter;
import com.bhx.securityconfig.permission.persistence.impl.PermissionServiceImpl;
import com.bhx.securityconfig.permission.persistence.repository.PermissionRepository;
import com.bhx.securityconfig.permission.delivery.converters.PermissionRestConverter;
import com.bhx.securityconfig.permission.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "KhaPhan" on 28-May-23
 */
@Configuration
public class PermissionConfiguration {
    @Autowired
    private PermissionRepository permissionRepository;

    @Bean
    public PermissionRepositoryConverter permissionRepositoryConverter() {
        return new PermissionRepositoryConverter();
    }

    @Bean
    public PermissionServiceImpl permissionService() {
        return new PermissionServiceImpl(permissionRepository, permissionRepositoryConverter());
    }

    @Bean
    public PermissionRestConverter permissionRestConverter() {
        return new PermissionRestConverter();
    }

    @Bean
    public GetAllPermissionUseCaseImpl getAllPermissionUseCase() {
        return new GetAllPermissionUseCaseImpl(permissionService());
    }

    @Bean
    public CreatePermissionUseCaseImpl createPermissionUseCase() {
        return new CreatePermissionUseCaseImpl(permissionService());
    }

    @Bean
    public GetOnePermissionUseCaseImpl getOnePermissionUseCase() {
        return new GetOnePermissionUseCaseImpl(permissionService());
    }

    @Bean
    public InvalidPermissionUseCaseImpl invalidPermissionUseCase() {
        return new InvalidPermissionUseCaseImpl(permissionService());
    }

    @Bean
    public UpdatePermissionUseCaseImpl updatePermissionUseCase() {
        return new UpdatePermissionUseCaseImpl(permissionService());
    }

}
