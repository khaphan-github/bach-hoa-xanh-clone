package com.bhx.securityconfig.configuration;

import com.bhx.group.persistence.impl.GroupServiceImpl;
import com.bhx.permission.persistence.impl.PermissionServiceImpl;
import com.bhx.policy.usecase.CanAccessResourceUseCaseImpl;
import com.bhx.policy.usecase.IsPublicResourceUseCaseImpl;
import com.bhx.user.persistence.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "KhaPhan" on 15-Jun-23
 */
@Configuration
public class PolicyConfiguration {
    @Autowired
    private GroupServiceImpl groupService;
    @Autowired
    private PermissionServiceImpl permissionService;
    @Autowired
    private AccountServiceImpl accountService;

    @Bean
    public CanAccessResourceUseCaseImpl canAccessResourceUseCase() {
        return new CanAccessResourceUseCaseImpl(permissionService, accountService);
    }

    @Bean
    public IsPublicResourceUseCaseImpl isPublicResourceUseCase() {
        return new IsPublicResourceUseCaseImpl(groupService, permissionService);
    }
}
