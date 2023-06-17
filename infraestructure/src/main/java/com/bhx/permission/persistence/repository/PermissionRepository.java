package com.bhx.permission.persistence.repository;

import com.bhx.permission.persistence.entities.PermissionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 22-May-23
 */

@Repository
public interface PermissionRepository extends MongoRepository<PermissionEntity, String> {
    boolean existsByName(String name);
    Collection<PermissionEntity> findByAccessGroupIds(String accessGroupId);
    PermissionEntity findByUriAndHttpMethodAndActive(String uri, String httpMethod, boolean active);
}
