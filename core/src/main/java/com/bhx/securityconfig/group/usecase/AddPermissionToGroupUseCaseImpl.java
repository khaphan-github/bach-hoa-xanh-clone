package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.exceptions.PermissionAlreadyExistInGroupException;
import com.bhx.securityconfig.group.ports.GroupRepositoryService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class AddPermissionToGroupUseCaseImpl implements AddPermissionToGroupUseCase {
    private final GroupRepositoryService groupRepositoryService;

    @Override
    public void execute(String permissionId, List<Group> groupId) throws PermissionAlreadyExistInGroupException {
        groupRepositoryService.addPermissionToGroup(permissionId, groupId);
    }
}
