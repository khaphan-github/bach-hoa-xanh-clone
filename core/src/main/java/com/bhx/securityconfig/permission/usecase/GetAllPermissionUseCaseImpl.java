package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.permission.ports.PermissionRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class GetAllPermissionUseCaseImpl implements GetAllPermissionUseCase {
    private  final PermissionRepositoryService permissionRepositoryService;
    @Override
    public Collection<Permission> execute() {
        return permissionRepositoryService.getAllPermission();
    }
}
