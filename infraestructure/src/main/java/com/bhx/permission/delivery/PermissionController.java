package com.bhx.permission.delivery;

import com.bhx.permission.delivery.request.CreatePermissionDto;
import com.bhx.permission.delivery.response.PermissionView;
import org.springframework.ui.Model;

/**
 * @author "KhaPhan" on 22-May-23
 */
public interface PermissionController {

    String createPermission(CreatePermissionDto createPermission);

    String getAllPermission(Model model);

    String getOnePermission(String id);

    String invalidPermission(String id);

    String updatePermission(PermissionView permissionView);
}
