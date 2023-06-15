package com.bhx.permission.configuration;

import com.bhx.group.persistence.impl.GroupServiceImpl;
import com.bhx.permission.delivery.converters.CreatePermissionConverter;
import com.bhx.permission.persistence.converters.PermissionRepositoryConverter;
import com.bhx.permission.persistence.repository.PermissionRepository;
import com.bhx.permission.persistence.impl.PermissionServiceImpl;
import com.bhx.permission.delivery.converters.PermissionRestConverter;
import com.bhx.permission.usecase.*;
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

    @Autowired
    private GroupServiceImpl groupService;
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
    public CreatePermissionConverter createPermissionConverter() {
        return new CreatePermissionConverter();
    }
    
    @Bean
    public GetAllPermissionUseCaseImpl getAllPermissionUseCase() {
        return new GetAllPermissionUseCaseImpl(permissionService(), groupService);
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
