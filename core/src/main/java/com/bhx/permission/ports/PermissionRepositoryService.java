package com.bhx.permission.ports;

import com.bhx.permission.Permission;

import java.util.Collection;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface PermissionRepositoryService {
    Collection<Permission> getAllPermission();

    void savePermission(Permission permission);

    void updatePermission(Permission permission);

    void deletePermission(String id);

    Permission getPermissionById(String id);

    void invalidPermission(String id);

    Boolean isExistPermissionName(String name);
}
