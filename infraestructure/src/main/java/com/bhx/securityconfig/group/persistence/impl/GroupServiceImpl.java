package com.bhx.securityconfig.group.persistence.impl;

import com.bhx.menu.Menu;
import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.exceptions.MenuAlreadyExistInGroupException;
import com.bhx.securityconfig.group.exceptions.PermissionAlreadyExistInGroupException;
import com.bhx.securityconfig.group.exceptions.UserAlreadyInGroupException;
import com.bhx.securityconfig.group.persistence.converters.GroupRepositoryConverter;
import com.bhx.securityconfig.group.persistence.repository.GroupRepository;
import com.bhx.securityconfig.group.ports.GroupRepositoryService;
import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.user.Account;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author "KhaPhan" on 10-Jun-23
 */
@AllArgsConstructor
public class GroupServiceImpl implements GroupRepositoryService {
    private final GroupRepository groupRepository;
    private final GroupRepositoryConverter groupRepositoryConverter;

    @Override
    public Collection<Group> getGroups() {
        return groupRepository.findAll().stream().map(groupRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void createGroup(Group group) {
        this.groupRepository.save(groupRepositoryConverter.mapToTable(group));
    }

    @Override
    public Collection<Group> getActiveGroup() {
        return this.groupRepository.getActiveGroup().stream().map(groupRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public Group getGroupById(String id) {
        return null;
    }

    @Override
    public Collection<Menu> getMenusInGroup(String groupId) {
        return null;
    }

    @Override
    public Collection<Permission> getPermissionsInGroup(String groupId) {
        return null;
    }

    @Override
    public Collection<Account> getAccountInGroup(String groupId) {
        return null;
    }

    @Override
    public void removeGroupById(String id) {

    }

    @Override
    public void addAccountsToGroup(String groupId, List<Account> accounts) throws UserAlreadyInGroupException {

    }

    @Override
    public void addPermissionToGroup(String permissionId, List<Group> groups) throws PermissionAlreadyExistInGroupException {

    }

    @Override
    public void addMenusToGroup(String groupId, List<Menu> menus) throws MenuAlreadyExistInGroupException {

    }
}
