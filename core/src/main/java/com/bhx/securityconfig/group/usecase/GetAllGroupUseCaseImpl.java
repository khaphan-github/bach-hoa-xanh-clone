package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.ports.GroupRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-Jun-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class GetAllGroupUseCaseImpl implements GetAllGroupsUseCase {
    private final GroupRepositoryService groupRepositoryService;
    @Override
    public Collection<Group> execute() {
        return groupRepositoryService.getGroups();
    }
}
