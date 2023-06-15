package com.bhx.permission.persistence.converters;

import com.bhx.permission.persistence.entities.PermissionEntity;
import com.bhx.global.shared.RepositoryConverter;
import com.bhx.permission.Permission;

/**
 * @author "KhaPhan" on 22-May-23
 */
public class PermissionRepositoryConverter implements RepositoryConverter<PermissionEntity, Permission> {
    @Override
    public PermissionEntity mapToTable(final Permission persistenceObject) {
        return new PermissionEntity();
    }

    @Override
    public Permission mapToEntity(final PermissionEntity entityObject) {
        return new Permission();
    }
}
