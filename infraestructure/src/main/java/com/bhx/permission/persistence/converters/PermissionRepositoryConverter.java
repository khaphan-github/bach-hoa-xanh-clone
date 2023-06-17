package com.bhx.permission.persistence.converters;

import com.bhx.permission.Effect;
import com.bhx.permission.persistence.entities.PermissionEntity;
import com.bhx.global.shared.RepositoryConverter;
import com.bhx.permission.Permission;
import org.bson.types.ObjectId;

/**
 * @author "KhaPhan" on 22-May-23
 */
public class PermissionRepositoryConverter implements RepositoryConverter<PermissionEntity, Permission> {
    @Override
    public PermissionEntity mapToTable(final Permission persistenceObject) {
        PermissionEntity permissionEntity = new PermissionEntity();

        permissionEntity.setId(persistenceObject.getId());

        permissionEntity.setName(persistenceObject.getName());
        permissionEntity.setUri(persistenceObject.getUri());
        permissionEntity.setHttpMethod(persistenceObject.getHttpMethod());
        permissionEntity.setEffect(persistenceObject.getEffect());
        permissionEntity.setDescription(persistenceObject.getDescription());

        permissionEntity.setAccessGroupIds(persistenceObject.getAccessGroupIds());

        permissionEntity.setActive(persistenceObject.isActive());

        permissionEntity.setCreatedAt(persistenceObject.getCreatedAt());
        permissionEntity.setUpdatedAt(persistenceObject.getUpdatedAt());

        return permissionEntity;
    }

    @Override
    public Permission mapToEntity(final PermissionEntity entityObject) {
        Permission permission = new Permission();
        permission.setId(entityObject.getId());

        permission.setUri(entityObject.getUri());
        permission.setAccessGroupIds(entityObject.getAccessGroupIds());
        permission.setName(entityObject.getName());
        permission.setEffect(entityObject.getEffect());
        permission.setDescription(entityObject.getDescription());
        permission.setHttpMethod(entityObject.getHttpMethod());
        permission.setActive(entityObject.isActive());

        return permission;
    }
}
