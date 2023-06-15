package com.bhx.group.usecase;

import com.bhx.group.Group;
import com.bhx.group.exceptions.PermissionAlreadyExistInGroupException;
import com.bhx.group.ports.GroupRepositoryService;
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
