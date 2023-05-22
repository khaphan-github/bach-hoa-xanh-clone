package com.bhx.permission.usecase;

import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.ports.PermissionRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class UpdatePermissionUseCaseImpl implements UpdatePermissionUseCase{
    private final PermissionRepositoryService permissionRepositoryService;
    @Override
    public void execute(Permission permission) throws PermissionNotFoundException {
        Permission permissionStored = permissionRepositoryService.getPermissionById(permission.getId());
        if (permissionStored == null) {
            throw new PermissionNotFoundException();
        }
        permissionRepositoryService.updatePermission(permission);
    }
}
