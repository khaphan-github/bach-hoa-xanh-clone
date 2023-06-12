package com.bhx.productInventory.persistence.repositories;

import com.bhx.productInventory.ProductInventory;
import com.bhx.productInventory.persistence.entities.ProductInventoryEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductInventoryRepository extends MongoRepository<ProductInventoryEntity, String> {

    @Query("{'storageId': ?0}")
    public ProductInventory findByStorageId(String id);

    @Query(value = "{'storageId': ?0}", fields = "{'productId': 1}")
    List<String> findProductIdsByStorageId(String storageId);

}
