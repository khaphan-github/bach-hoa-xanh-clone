package com.bhx.securityconfig.permission.delivery.converters;

import com.bhx.securityconfig.permission.delivery.response.PermissionView;
import com.bhx.global.shared.RestConverter;
import com.bhx.securityconfig.permission.Permission;

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
        return new PermissionView(
                entity.getId(),
                entity.getAction(),
                entity.getDesc(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.isActive()
        );
    }
}
