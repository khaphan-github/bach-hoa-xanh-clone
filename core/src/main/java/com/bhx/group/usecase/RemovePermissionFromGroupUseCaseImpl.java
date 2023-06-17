package com.bhx.group.usecase;

import com.bhx.group.ports.GroupRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class RemovePermissionFromGroupUseCaseImpl implements RemovePermissionFromGroupUseCase {
    private final GroupRepositoryService groupRepositoryService;

    @Override
    public void execute(String permissionId, String groupId) {

    }
}
