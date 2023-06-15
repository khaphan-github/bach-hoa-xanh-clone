package com.bhx.permission.usecase;

import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.Permission;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface GetOnePermissionUseCase {
    Permission execute(String id) throws PermissionNotFoundException;
}
