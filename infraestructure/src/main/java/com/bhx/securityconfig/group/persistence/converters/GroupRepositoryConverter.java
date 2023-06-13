package com.bhx.securityconfig.group.persistence.converters;

import com.bhx.global.shared.RepositoryConverter;
import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.persistence.entities.GroupEntity;

import java.util.Date;

/**
 * @author "KhaPhan" on 13-Jun-23
 */
public class GroupRepositoryConverter implements RepositoryConverter<GroupEntity, Group> {
    @Override
    public GroupEntity mapToTable(final Group persistenceObject) {
        return new GroupEntity(
                persistenceObject.getId(),
                persistenceObject.getName(),
                persistenceObject.getDescription(),
                persistenceObject.isActive(),
                new Date(),
                new Date()
        );
    }

    @Override
    public Group mapToEntity(final GroupEntity entityObject) {
        return new Group(
                entityObject.getId(),
                entityObject.getName(),
                entityObject.getDesc(),
                entityObject.isActive()
        );
    }
}
