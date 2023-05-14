package com.bhx.category.persistence.repositories;

import java.util.Collection;

import com.bhx.category.Category;
import com.bhx.category.persistence.entities.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryEntity, String> {

	public Collection<Category> findByName(String name);
}
