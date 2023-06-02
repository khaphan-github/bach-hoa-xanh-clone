package com.bhx.rootcategory.persistence.impl;

import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.rootcategory.ports.RootCategoryRepositoryService;
import lombok.AllArgsConstructor;


public class RootCategoryServiceImpl implements RootCategoryRepositoryService {


    public RootCategoryServiceImpl() {
    }

    @Override
    public int GetLastId() {
        return 0;
    }
}
