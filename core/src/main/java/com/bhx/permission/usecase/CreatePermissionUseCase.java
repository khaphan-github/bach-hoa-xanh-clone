package com.bhx.permission.usecase;

import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionAlreadyExist;

/**
 * @author "KhaPhan" on 20-May-23
 */
interface CreatePermissionUseCase {
    void execute(Permission permission) throws PermissionAlreadyExist;
}
