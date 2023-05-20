package com.bhx.product.persistence.repositories;

import com.bhx.product.persistence.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    @Query("{'categoryId': ?0}")
    Collection<ProductEntity> findByCategoryId(String categoryId);

    Collection<ProductEntity> findByName(String name);


}
