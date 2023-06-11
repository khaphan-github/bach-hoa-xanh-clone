package com.bhx.securityconfig.group.persistence.repository;

import com.bhx.securityconfig.group.persistence.entities.GroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "KhaPhan" on 10-Jun-23
 */

@Repository
public interface GroupRepository extends MongoRepository<GroupEntity, String> {
}
