package com.bhx.securityconfig.group.confiuration;

import com.bhx.securityconfig.group.delivery.converters.GroupRestConverter;
import com.bhx.securityconfig.group.persistence.impl.GroupServiceImpl;
import com.bhx.securityconfig.group.usecase.CreateGroupUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "KhaPhan" on 10-Jun-23
 */
@Configuration
public class GroupConfiguration {
    @Bean
    public GroupServiceImpl groupService() {
        return new GroupServiceImpl();
    }

    @Bean
    public GroupRestConverter groupRestConverter() {
        return new GroupRestConverter();
    }

    @Bean
    public CreateGroupUseCaseImpl createGroupUseCase() {
        return new CreateGroupUseCaseImpl(groupService());
    }
}
