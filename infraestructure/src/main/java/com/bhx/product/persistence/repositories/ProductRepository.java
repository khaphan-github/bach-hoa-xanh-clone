package com.bhx.product.persistence.repositories;

import com.bhx.product.persistence.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
