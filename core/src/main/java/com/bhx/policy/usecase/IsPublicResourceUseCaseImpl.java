package com.bhx.policy.usecase;

import com.bhx.group.Group;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.permission.ports.PermissionRepositoryService;
import com.bhx.policy.Credential;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * @author "KhaPhan" on 15-Jun-23
 */
@AllArgsConstructor
public class IsPublicResourceUseCaseImpl implements IsPublicResourceUseCase {
    private final GroupRepositoryService groupRepositoryService;
    private final PermissionRepositoryService permissionRepositoryService;

    @Override
    public boolean execute(Credential credential, String publicResourceName) throws PermissionNotFoundException {
        Group groupForEveryone = groupRepositoryService.findByNameAndActive(publicResourceName);

        Collection<Permission> permissions = permissionRepositoryService.findPermissionByGroupId(groupForEveryone.getId());

        if (permissions.isEmpty()) {
            throw new PermissionNotFoundException("Permission not found");
        }

        for (Permission permission : permissions) {
            boolean isMatchUri = credential.getUri().startsWith(permission.getUri());
            boolean isMatchMethod = credential.getHttpMethod().equals(permission.getHttpMethod());

            if (isMatchUri && isMatchMethod) {
                return true;
            }
        }

        return false;
    }
}
