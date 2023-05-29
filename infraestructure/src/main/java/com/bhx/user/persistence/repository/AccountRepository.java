package com.bhx.user.persistence.repository;

import com.bhx.user.persistence.entities.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author "KhaPhan" on 28-May-23
 */
@Repository
public interface AccountRepository extends MongoRepository<AccountEntity, String> {

    @Query("{ username : ?0 }")
    public Optional<AccountEntity> findByUsername(String username);
}
