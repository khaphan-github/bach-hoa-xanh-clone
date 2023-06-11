package com.bhx.securityconfig.group.ports;

import com.bhx.menu.Menu;
import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.exceptions.MenuAlreadyExistInGroupException;
import com.bhx.securityconfig.group.exceptions.PermissionAlreadyExistInGroupException;
import com.bhx.securityconfig.group.exceptions.UserAlreadyInGroupException;
import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.user.Account;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 */
public interface GroupRepositoryService {
    Collection<Group> getGroups();

    Group getGroupById(String id);

    Collection<Menu> getMenusInGroup(String groupId);

    Collection<Permission> getPermissionsInGroup(String groupId);

    Collection<Account> getAccountInGroup(String groupId);

    void removeGroupById(String id);

    void addAccountsToGroup(String groupId, List<Account> accounts) throws UserAlreadyInGroupException;

    void addPermissionToGroup(String permissionId, List<Group> groups) throws PermissionAlreadyExistInGroupException;

    void addMenusToGroup(String groupId, List<Menu> menus) throws MenuAlreadyExistInGroupException;
}
