package com.bhx.securityconfig.permission.delivery.impl;

import com.bhx.securityconfig.permission.delivery.PermissionController;
import com.bhx.securityconfig.permission.delivery.response.PermissionView;
import org.springframework.stereotype.Controller;

/**
 * @author "KhaPhan" on 22-May-23
 */

@Controller
public class PermissionControllerImpl implements PermissionController {

    @Override
    public String createPermission(PermissionView permissionView) {
        return null;
    }

    @Override
    public String getAllPermission() {
        return null;
    }

    @Override
    public String getOnePermission(String id) {
        return null;
    }

    @Override
    public String invalidPermission(String id) {
        return null;
    }

    @Override
    public String updatePermission(PermissionView permissionView) {
        return null;
    }
}
