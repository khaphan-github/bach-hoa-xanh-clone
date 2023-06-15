package com.bhx.group.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
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
