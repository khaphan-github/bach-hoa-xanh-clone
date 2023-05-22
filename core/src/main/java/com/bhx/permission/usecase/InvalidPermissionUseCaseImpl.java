package com.bhx.permission.usecase;

import com.bhx.permission.Permission;
import com.bhx.permission.exception.CanNotInvalidPermission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.ports.PermissionRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class InvalidPermissionUseCaseImpl implements InvalidPermissionUseCase {

    private final PermissionRepositoryService permissionRepositoryService;

    @Override
    public void execute(String id) throws PermissionNotFoundException, CanNotInvalidPermission {
        Permission permissionStored = permissionRepositoryService.getPermissionById(id);
        if (permissionStored == null) {
            throw new PermissionNotFoundException();
        }
        try {
            permissionRepositoryService.invalidPermission(permissionStored.getId());
        } catch (Exception e) {
            throw new CanNotInvalidPermission();
        }
    }
}
