package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.exception.CanNotInvalidPermission;
import com.bhx.securityconfig.permission.exception.PermissionNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface InvalidPermissionUseCase {
    void execute(String id) throws PermissionNotFoundException, CanNotInvalidPermission;
}
