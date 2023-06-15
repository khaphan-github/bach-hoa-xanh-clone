package com.bhx.permission.usecase;

import com.bhx.permission.exception.PermissionAlreadyExist;
import com.bhx.permission.Permission;

/**
 * @author "KhaPhan" on 20-May-23
 */
interface CreatePermissionUseCase {
    void execute(Permission permission) throws PermissionAlreadyExist;
}
