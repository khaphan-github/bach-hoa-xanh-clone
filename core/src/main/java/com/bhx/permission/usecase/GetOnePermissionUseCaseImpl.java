package com.bhx.permission.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.ports.PermissionRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class GetOnePermissionUseCaseImpl implements GetOnePermissionUseCase {

    private final PermissionRepositoryService permissionRepositoryService;
    private final GroupRepositoryService groupRepositoryService;

    @Override
    public Permission execute(String id) throws PermissionNotFoundException {
        Permission permissionStored = permissionRepositoryService.getPermissionById(id);
        if (permissionStored == null) {
            throw new PermissionNotFoundException(id);
        }
        Collection<Group> groups = groupRepositoryService.getGroups();
        permissionStored.setAccessGroups(groups);
        return permissionStored;
    }
}
