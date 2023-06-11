package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.ports.GroupRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class CreateGroupUseCaseImpl implements CreateGroupUseCase {
    private final GroupRepositoryService groupRepositoryService;
    @Override
    public void execute(Group group) {

    }
}
