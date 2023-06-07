package com.bhx.securityconfig.permission.delivery;

import com.bhx.securityconfig.permission.delivery.response.PermissionView;

/**
 * @author "KhaPhan" on 22-May-23
 */
public interface PermissionController {

    String createPermission(PermissionView permissionView);

    String getAllPermission();

    String getOnePermission(String id);

    String invalidPermission(String id);

    String updatePermission(PermissionView permissionView);
}
