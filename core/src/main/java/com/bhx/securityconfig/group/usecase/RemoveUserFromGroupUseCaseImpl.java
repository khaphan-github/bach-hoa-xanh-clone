package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.ports.GroupRepositoryService;
import lombok.AllArgsConstructor;

/**
 * @author "KhaPhan" on 08-Jun-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class RemoveUserFromGroupUseCaseImpl implements RemoveUserFromGroupUseCase {
    private final GroupRepositoryService groupRepositoryService;

    @Override
    public void execute(String userId, String groupId) {

    }
}
