package com.bhx.permission.delivery.converters;

import com.bhx.group.Group;
import com.bhx.permission.delivery.response.PermissionView;
import com.bhx.global.shared.RestConverter;
import com.bhx.permission.Permission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 22-May-23
 */
public class PermissionRestConverter implements RestConverter<PermissionView, Permission> {
    @Override
    public Permission mapToEntity(final PermissionView viewModel) {
        return new Permission();
    }

    @Override
    public PermissionView mapToRest(final Permission entity) {
        PermissionView permissionView = new PermissionView();
        permissionView.setId(entity.getId());
        permissionView.setName(entity.getName());
        permissionView.setUri(entity.getUri());

        List<String> groupNames = new ArrayList<>();
        for (Group group : entity.getAccessGroups()) {
            groupNames.add(group.getName());
        }
        permissionView.setGroupNames(groupNames);
        permissionView.setMethod(entity.getHttpMethod());
        permissionView.setActive(entity.isActive());
        permissionView.setDescription(entity.getDescription());

        return permissionView;
    }
}
