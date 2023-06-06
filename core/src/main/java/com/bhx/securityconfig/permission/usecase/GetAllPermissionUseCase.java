package com.bhx.securityconfig.permission.usecase;

import com.bhx.securityconfig.permission.Permission;

import java.util.Collection;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface GetAllPermissionUseCase {
    Collection<Permission> execute();
}
