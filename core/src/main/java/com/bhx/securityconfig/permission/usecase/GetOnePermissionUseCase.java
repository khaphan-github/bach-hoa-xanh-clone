package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.permission.exception.PermissionNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface GetOnePermissionUseCase {
    Permission execute(String id) throws PermissionNotFoundException;
}
