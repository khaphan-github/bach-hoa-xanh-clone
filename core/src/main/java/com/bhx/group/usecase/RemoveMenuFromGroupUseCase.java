package com.bhx.group.usecase;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface RemoveMenuFromGroupUseCase {
    void execute(String menuId, String groupId);
}
