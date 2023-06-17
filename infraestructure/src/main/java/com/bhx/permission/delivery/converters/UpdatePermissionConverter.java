package com.bhx.permission.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.permission.Permission;
import com.bhx.permission.delivery.request.UpdatePermissionDto;

import java.util.Date;

/**
 * @author "KhaPhan" on 16-Jun-23
 */
public class UpdatePermissionConverter implements RestConverter<UpdatePermissionDto, Permission> {
    @Override
    public Permission mapToEntity(final UpdatePermissionDto viewModel) {
        Permission permission = new Permission();
        permission.setId(viewModel.getId());

        permission.setName(viewModel.getName());
        permission.setHttpMethod(viewModel.getHttpMethod());
        permission.setDescription(viewModel.getDesc());
        permission.setUri(viewModel.getUri());
        permission.setActive(viewModel.isActive());
        permission.setAccessGroupIds(viewModel.getSelectedGroups());
        permission.setEffect(viewModel.getType());
        permission.setUpdatedAt(new Date());

        return permission;
    }

    @Override
    public UpdatePermissionDto mapToRest(final Permission entity) {
        UpdatePermissionDto updatePermissionDto = new UpdatePermissionDto();

        updatePermissionDto.setId(entity.getId());

        updatePermissionDto.setName(entity.getName());

        updatePermissionDto.setHttpMethod(entity.getHttpMethod());
        updatePermissionDto.setDesc(entity.getDescription());
        updatePermissionDto.setUri(entity.getUri());
        updatePermissionDto.setActive(entity.isActive());

        updatePermissionDto.setGroups(entity.getAccessGroups());
        updatePermissionDto.setSelectedGroups(entity.getAccessGroupIds());

        updatePermissionDto.setType(entity.getEffect());

        return updatePermissionDto;
    }
}
