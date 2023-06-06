package com.bhx.storage.persistence.repositories;

import com.bhx.storage.persistence.entities.StorageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends MongoRepository<StorageEntity, String> {
}
