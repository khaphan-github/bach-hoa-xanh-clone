package com.bhx.group.persistence.repository;

import com.bhx.group.persistence.entities.GroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 10-Jun-23
 */

@Repository
public interface GroupRepository extends MongoRepository<GroupEntity, String> {
    @Query("{ active : true }")
    Collection<GroupEntity> getActiveGroup();
    Collection<GroupEntity> findByIdIn(List<String> groupIds);
    GroupEntity findByNameAndActive(String name, boolean active);
}
