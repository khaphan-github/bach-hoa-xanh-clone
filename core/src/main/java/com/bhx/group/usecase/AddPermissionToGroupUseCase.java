package com.bhx.group.usecase;

import com.bhx.group.Group;
import com.bhx.group.exceptions.PermissionAlreadyExistInGroupException;

import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 */
public interface AddPermissionToGroupUseCase {
    void execute(String permissionId, List<Group> groupId) throws PermissionAlreadyExistInGroupException;
}
