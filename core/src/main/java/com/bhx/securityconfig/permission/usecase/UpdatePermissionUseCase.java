package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.permission.exception.PermissionNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface UpdatePermissionUseCase {
    void execute(Permission permission) throws PermissionNotFoundException;
}
