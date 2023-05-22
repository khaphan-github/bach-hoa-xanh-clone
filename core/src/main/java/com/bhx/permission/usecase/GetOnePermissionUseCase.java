package com.bhx.permission.usecase;

import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;

/**
 * @author "KhaPhan" on 20-May-23
 * @project clean-architecture
 */
public interface GetOnePermissionUseCase {
    Permission execute(String id) throws PermissionNotFoundException;
}
