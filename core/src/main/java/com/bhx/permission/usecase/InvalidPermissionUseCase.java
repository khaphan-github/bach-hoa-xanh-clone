package com.bhx.permission.usecase;

import com.bhx.permission.exception.CanNotInvalidPermission;
import com.bhx.permission.exception.PermissionNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface InvalidPermissionUseCase {
    void execute(String id) throws PermissionNotFoundException, CanNotInvalidPermission;
}
