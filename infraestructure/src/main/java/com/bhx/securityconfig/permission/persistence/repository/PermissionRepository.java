package com.bhx.securityconfig.permission.persistence.repository;

import com.bhx.securityconfig.permission.persistence.entities.PermissionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "KhaPhan" on 22-May-23
 */

@Repository
public interface PermissionRepository extends MongoRepository<PermissionEntity, String> {
    boolean existsByName(String name);
}
