package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.exceptions.PermissionAlreadyExistInGroupException;

import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 */
public interface AddPermissionToGroupUseCase {
    void execute(String permissionId, List<Group> groupId) throws PermissionAlreadyExistInGroupException;
}
