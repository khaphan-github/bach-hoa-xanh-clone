package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.permission.exception.PermissionNotFoundException;
import com.bhx.securityconfig.permission.ports.PermissionRepositoryService;
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
            throw new PermissionNotFoundException(permission.getId());
        }
        permissionRepositoryService.updatePermission(permission);
    }
}
