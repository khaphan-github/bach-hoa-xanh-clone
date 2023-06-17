package com.bhx.permission.persistence.impl;

import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.persistence.converters.PermissionRepositoryConverter;
import com.bhx.permission.persistence.entities.PermissionEntity;
import com.bhx.permission.persistence.repository.PermissionRepository;
import com.bhx.permission.Permission;
import com.bhx.permission.ports.PermissionRepositoryService;
import com.bhx.policy.Credential;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author "KhaPhan" on 22-May-23
 */
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionRepositoryService {

    private final PermissionRepository permissionRepository;
    private final PermissionRepositoryConverter permissionRepositoryConverter;

    @Override
    public Collection<Permission> getAllPermission() {
        return permissionRepository.findAll().stream().map(permissionRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<Permission> findPermissionByGroupId(String groupId) throws PermissionNotFoundException {
        return permissionRepository.findByAccessGroupIds(groupId).stream().map(permissionRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public Permission getPermissionByCredential(Credential credential) throws PermissionNotFoundException {
        PermissionEntity permissionEntity = permissionRepository.findByUriAndHttpMethodAndActive(credential.getUri(), credential.getHttpMethod(), true);

        return permissionRepositoryConverter.mapToEntity(permissionEntity);
    }

    @Override
    public void savePermission(Permission permission) {
        PermissionEntity permissionEntity = permissionRepositoryConverter.mapToTable(permission);
        permissionRepository.save(permissionEntity);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionRepository.save(permissionRepositoryConverter.mapToTable(permission));
    }

    @Override
    public void deletePermission(String id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public Permission getPermissionById(String id) {
        Optional<PermissionEntity> permissionEntity = permissionRepository.findById(id);
        return permissionEntity.map(permissionRepositoryConverter::mapToEntity).orElse(null);
    }

    @Override
    public void invalidPermission(String id) {
        Permission permissionStored = getPermissionById(id);
        permissionStored.setActive(false);
        updatePermission(permissionStored);
    }

    @Override
    public Boolean isExistPermissionName(String name) {
        return permissionRepository.existsByName(name);
    }
}
