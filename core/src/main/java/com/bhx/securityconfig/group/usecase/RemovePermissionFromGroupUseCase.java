package com.bhx.securityconfig.group.usecase;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface RemovePermissionFromGroupUseCase {
    void execute(String permissionId, String groupId);
}
