package com.bhx.group.persistence.impl;

import com.bhx.group.persistence.converters.GroupRepositoryConverter;
import com.bhx.group.persistence.entities.GroupEntity;
import com.bhx.group.persistence.repository.GroupRepository;
import com.bhx.group.Group;
import com.bhx.group.exceptions.MenuAlreadyExistInGroupException;
import com.bhx.group.exceptions.PermissionAlreadyExistInGroupException;
import com.bhx.group.exceptions.UserAlreadyInGroupException;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.permission.Permission;
import com.bhx.user.Account;
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
    public Collection<Group> getGroupsByGroupIds(List<String> groupIds) {
        return this.groupRepository.findByIdIn(groupIds).stream().map(groupRepositoryConverter::mapToEntity).collect(Collectors.toList());
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
    public Group findByNameAndActive(String name) {
        GroupEntity groupEntity = groupRepository.findByNameAndActive(name, true);
        return groupRepositoryConverter.mapToEntity(groupEntity);
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
}
