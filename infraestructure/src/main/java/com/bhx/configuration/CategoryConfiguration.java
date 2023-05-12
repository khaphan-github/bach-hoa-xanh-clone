package com.bhx.configuration;

import com.bhx.category.usecase.CreateCategoryUseCaseImpl;
import com.bhx.category.usecase.GetAllCategoriesUseCaseImpl;
import com.bhx.persistence.converters.CategoryRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bhx.delivery.converters.CategoryRestConverter;
import com.bhx.persistence.impl.CategoryServiceImpl;
import com.bhx.persistence.repositories.CategoryRepository;

@Configuration
public class CategoryConfiguration {

	
	@Autowired
	private CategoryRepository categoryRepository;


	@Bean
	public CategoryRepositoryConverter createCategoryRepositoryConverter() {
		return new CategoryRepositoryConverter();
	}

	@Bean
	public CategoryRestConverter createCategoryRestConverter() {
		return new CategoryRestConverter();
	}

	@Bean
	public CategoryServiceImpl createCategoriServiceImpl() {
		return new CategoryServiceImpl(categoryRepository, createCategoryRepositoryConverter());
	}

	@Bean
	public GetAllCategoriesUseCaseImpl createGetAllCategoriesUseCase() {
		return new GetAllCategoriesUseCaseImpl(createCategoriServiceImpl());
	}
	
	@Bean
	public CreateCategoryUseCaseImpl createCreateCategoryUseCase() {
		return new CreateCategoryUseCaseImpl(createCategoriServiceImpl());
	}

}