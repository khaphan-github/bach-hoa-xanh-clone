package com.bhx.group.ports;

import com.bhx.group.Group;
import com.bhx.group.exceptions.MenuAlreadyExistInGroupException;
import com.bhx.group.exceptions.PermissionAlreadyExistInGroupException;
import com.bhx.group.exceptions.UserAlreadyInGroupException;
import com.bhx.permission.Permission;
import com.bhx.user.Account;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 */
public interface GroupRepositoryService {
    Collection<Group> getGroups();
    Collection<Group> getGroupsByGroupIds(List<String> groupIds);
    void createGroup(Group group);
    Collection<Group> getActiveGroup();
    Group getGroupById(String id);
    Group findByNameAndActive(String name);

    Collection<Permission> getPermissionsInGroup(String groupId);

    Collection<Account> getAccountInGroup(String groupId);

    void removeGroupById(String id);

    void addAccountsToGroup(String groupId, List<Account> accounts) throws UserAlreadyInGroupException;

    void addPermissionToGroup(String permissionId, List<Group> groups) throws PermissionAlreadyExistInGroupException;

}
