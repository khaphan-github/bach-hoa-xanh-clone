package com.bhx.permission.usecase;

import com.bhx.permission.Permission;
import com.bhx.permission.ports.PermissionRepositoryService;
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
