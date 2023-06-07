package com.bhx.storage.persistence.repositories;

import com.bhx.product.persistence.entities.ProductEntity;
import com.bhx.storage.persistence.entities.StorageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StorageRepository extends MongoRepository<StorageEntity, String> {
    @Query("{'productId': ?0}")
    Collection<StorageEntity> findByProductId(String categoryId);

    Collection<StorageEntity> findByName(String name);

}
