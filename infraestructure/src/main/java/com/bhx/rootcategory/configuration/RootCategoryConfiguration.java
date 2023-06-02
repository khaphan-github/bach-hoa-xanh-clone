package com.bhx.rootcategory.configuration;

import com.bhx.rootcategory.persistence.repositories.RootCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootCategoryConfiguration {

    @Autowired
    private RootCategoryRepository rootCategoryRepository;
}
