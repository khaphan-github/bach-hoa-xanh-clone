package com.bhx.group.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class CreateGroupUseCaseImpl implements CreateGroupUseCase {
    private final GroupRepositoryService groupRepositoryService;
    @Override
    public void execute(Group group) {
        groupRepositoryService.createGroup(group);
    }
}
