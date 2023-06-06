package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.permission.exception.PermissionNotFoundException;
import com.bhx.securityconfig.permission.ports.PermissionRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class GetOnePermissionUseCaseImpl implements GetOnePermissionUseCase {

    private final PermissionRepositoryService permissionRepositoryService;

    @Override
    public Permission execute(String id) throws PermissionNotFoundException {
        Permission permissionStored = permissionRepositoryService.getPermissionById(id);
        if (permissionStored == null) {
            throw new PermissionNotFoundException(id);
        }
        return permissionStored;
    }
}
