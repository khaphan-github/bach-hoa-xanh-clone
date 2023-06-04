package com.bhx.rootcategory.configuration;

import com.bhx.rootcategory.RootCategory;
import com.bhx.rootcategory.delivery.converters.RootCategoryMvcConverter;
import com.bhx.rootcategory.persistence.converters.RootCategoryRepositoryConverter;
import com.bhx.rootcategory.persistence.impl.RootCategoryServiceImpl;
import com.bhx.rootcategory.persistence.repositories.RootCategoryRepository;
import com.bhx.rootcategory.usecase.GetLastIdUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootCategoryConfiguration {

    @Autowired
    private RootCategoryRepository rootCategoryRepository;

    @Bean
    public RootCategoryMvcConverter rootCategoryMvcConverter() {return new RootCategoryMvcConverter();}

    @Bean
    public RootCategoryRepositoryConverter rootCategoryRepositoryConverter(){return new RootCategoryRepositoryConverter();}


    @Bean
    public RootCategoryServiceImpl rootCategoryService(){
        return new RootCategoryServiceImpl(this.rootCategoryRepository, rootCategoryRepositoryConverter());
    }

    @Bean
    public GetLastIdUseCaseImpl getLastIdUseCase(){return new GetLastIdUseCaseImpl(rootCategoryService());}
}
