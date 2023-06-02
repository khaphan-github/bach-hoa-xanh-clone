package com.bhx.rootcategory.persistence.repositories;

import com.bhx.rootcategory.persistence.entities.RootCategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RootCategoryRepository extends MongoRepository<RootCategoryEntity, String> {

    int findFirstByOrderByidDesc();
}
