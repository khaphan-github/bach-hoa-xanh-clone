package com.bhx.securityconfig.permission.persistence.converters;

import com.bhx.securityconfig.permission.persistence.entities.PermissionEntity;
import com.bhx.global.shared.RepositoryConverter;
import com.bhx.securityconfig.permission.Permission;

/**
 * @author "KhaPhan" on 22-May-23
 */
public class PermissionRepositoryConverter implements RepositoryConverter<PermissionEntity, Permission> {
    @Override
    public PermissionEntity mapToTable(final Permission persistenceObject) {
        return new PermissionEntity(persistenceObject.getId(), persistenceObject.getAction(), persistenceObject.getDesc(), persistenceObject.getCreatedAt(), persistenceObject.getUpdatedAt(), persistenceObject.isActive());
    }

    @Override
    public Permission mapToEntity(final PermissionEntity entityObject) {
        return new Permission();
    }
}
