package com.bhx.category.persistence.repositories;

import java.util.Collection;

import com.bhx.category.Category;
import com.bhx.category.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	public Collection<Category> findByName(String name);
}
