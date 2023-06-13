package com.bhx.securityconfig.group.confiuration;

import com.bhx.securityconfig.group.delivery.converters.GroupRestConverter;
import com.bhx.securityconfig.group.persistence.converters.GroupRepositoryConverter;
import com.bhx.securityconfig.group.persistence.impl.GroupServiceImpl;
import com.bhx.securityconfig.group.persistence.repository.GroupRepository;
import com.bhx.securityconfig.group.usecase.CreateGroupUseCaseImpl;
import com.bhx.securityconfig.group.usecase.GetActiveGroupUseCaseImpl;
import com.bhx.securityconfig.group.usecase.GetAllGroupUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "KhaPhan" on 10-Jun-23
 */
@Configuration
public class GroupConfiguration {
    @Autowired
    private GroupRepository groupRepository;

    @Bean
    public GroupRestConverter groupRestConverter() {
        return new GroupRestConverter();
    }

    @Bean
    public GroupRepositoryConverter groupRepositoryConverter() {
        return new GroupRepositoryConverter();
    }

    @Bean
    public GroupServiceImpl groupService() {
        return new GroupServiceImpl(groupRepository, groupRepositoryConverter());
    }

    @Bean
    public CreateGroupUseCaseImpl createGroupUseCase() {
        return new CreateGroupUseCaseImpl(groupService());
    }

    @Bean
    public GetAllGroupUseCaseImpl  getAllGroupUseCase() {
        return new GetAllGroupUseCaseImpl(groupService());
    }

    @Bean
    public GetActiveGroupUseCaseImpl getActiveGroupUseCase() {
        return new GetActiveGroupUseCaseImpl(groupService());
    }
}
