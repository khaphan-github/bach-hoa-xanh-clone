package com.bhx.securityconfig.group.usecase;

/**
 * @author "KhaPhan" on 06-Jun-23
 */
public interface RemoveUserFromGroupUseCase {
    void execute(String userId, String groupId);
}
