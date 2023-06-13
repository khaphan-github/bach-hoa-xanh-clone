package com.bhx.securityconfig.group.persistence.repository;

import com.bhx.securityconfig.group.persistence.entities.GroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author "KhaPhan" on 10-Jun-23
 */

@Repository
public interface GroupRepository extends MongoRepository<GroupEntity, String> {
    @Query("{ active : true }")
    Collection<GroupEntity> getActiveGroup();
}
