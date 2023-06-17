package com.bhx.permission.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.permission.Effect;
import com.bhx.permission.Permission;
import com.bhx.permission.delivery.request.CreatePermissionDto;
import com.bhx.permission.delivery.response.PermissionView;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

/**
 * @author "KhaPhan" on 15-Jun-23
 * @project clean-architecture
 */
public class CreatePermissionConverter implements RestConverter<CreatePermissionDto, Permission> {
    @Override
    public Permission mapToEntity(final CreatePermissionDto createPermissionDto) {
        Permission permission = new Permission();

        permission.setId(new ObjectId().toString());
        permission.setName(createPermissionDto.getName());
        permission.setUri(createPermissionDto.getUri());
        permission.setHttpMethod(createPermissionDto.getHttpMethod());
        permission.setEffect(createPermissionDto.getType());
        permission.setDescription(createPermissionDto.getDesc());

        permission.setAccessGroupIds(Arrays.asList(createPermissionDto.getSelectedGroups()));

        permission.setActive(createPermissionDto.isActive());

        permission.setCreatedAt(new Date());
        permission.setUpdatedAt(new Date());

        return permission;
    }

    @Override
    public CreatePermissionDto mapToRest(final Permission entity) {
        return null;
    }
}
