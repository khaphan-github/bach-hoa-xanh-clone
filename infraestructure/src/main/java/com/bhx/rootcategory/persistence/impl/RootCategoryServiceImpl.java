package com.bhx.rootcategory.persistence.impl;

import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.rootcategory.persistence.converters.RootCategoryRepositoryConverter;
import com.bhx.rootcategory.persistence.entities.RootCategoryEntity;
import com.bhx.rootcategory.persistence.repositories.RootCategoryRepository;
import com.bhx.rootcategory.ports.RootCategoryRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RootCategoryServiceImpl implements RootCategoryRepositoryService {
    private final RootCategoryRepository rootCategoryRepository;
    private final RootCategoryRepositoryConverter rootCategoryRepositoryConverter;

    @Override
    public int GetLastId() {
        RootCategoryEntity rootCategory = new RootCategoryEntity(null,"Test");
        rootCategoryRepository.save(rootCategory);
        return 123;
    }
}
