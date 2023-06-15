package com.bhx.permission.usecase;

import com.bhx.permission.exception.PermissionAlreadyExist;
import com.bhx.permission.ports.PermissionRepositoryService;
import com.bhx.permission.Permission;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class CreatePermissionUseCaseImpl implements CreatePermissionUseCase {

     private final PermissionRepositoryService permissionRepositoryService;
    @Override
    public void execute(Permission permission) throws PermissionAlreadyExist {
        Boolean isExistPermission = permissionRepositoryService.isExistPermissionName(permission.getAction());
        if (Boolean.TRUE.equals(isExistPermission)) {
            throw new PermissionAlreadyExist();
        }
        permissionRepositoryService.savePermission(permission);
    }
}
