package com.bhx.permission.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.permission.delivery.response.PermissionView;
import com.bhx.permission.Permission;

/**
 * @author "KhaPhan" on 22-May-23
 */
public class PermissionRestConverter implements RestConverter<PermissionView, Permission> {
    @Override
    public Permission mapToEntity(final PermissionView viewModel) {
        return new Permission(
                viewModel.getId(),
                viewModel.getName(),
                viewModel.getDesc(),
                viewModel.getCreatedAt(),
                viewModel.getUpdatedAt(),
                viewModel.isActive()
        );
    }

    @Override
    public PermissionView mapToRest(final Permission entity) {
        return new PermissionView(
                entity.getId(),
                entity.getName(),
                entity.getDesc(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.isActive()
        );
    }
}
