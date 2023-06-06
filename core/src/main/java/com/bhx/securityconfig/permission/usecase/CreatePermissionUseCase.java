package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.permission.exception.PermissionAlreadyExist;

/**
 * @author "KhaPhan" on 20-May-23
 */
interface CreatePermissionUseCase {
    void execute(Permission permission) throws PermissionAlreadyExist;
}
