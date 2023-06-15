package com.bhx.permission.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.permission.ports.PermissionRepositoryService;
import com.bhx.permission.Permission;
import com.bhx.user.Account;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class GetAllPermissionUseCaseImpl implements GetAllPermissionUseCase {
    private  final PermissionRepositoryService permissionRepositoryService;
    private final GroupRepositoryService groupRepositoryService;
    @Override
    public Collection<Permission> execute() {
        Collection<Permission> permissions =  permissionRepositoryService.getAllPermission();
        for (Permission permission : permissions) {
            List<Group> groups = (List<Group>) groupRepositoryService.getGroupsByGroupIds(permission.getAccessGroupIds());
            permission.setAccessGroups(groups);
        }
        return permissions;
    }
}
