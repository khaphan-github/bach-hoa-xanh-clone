package com.bhx.category.configuration;

import com.bhx.category.delivery.converters.CategoryRestConverter;
import com.bhx.category.persistence.converters.CategoryRepositoryConverter;
import com.bhx.category.persistence.repositories.CategoryRepository;
import com.bhx.category.usecase.CreateCategoryUseCaseImpl;
import com.bhx.category.usecase.DeleteACategoryUseCaseImpl;
import com.bhx.category.usecase.GetAllCategoriesUseCaseImpl;
import com.bhx.category.usecase.UpdateCategoryUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bhx.category.persistence.impl.CategoryServiceImpl;


@Configuration
public class CategoryConfiguration {

	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryServiceImpl categoryService;


	@Bean
	public CategoryRepositoryConverter createCategoryRepositoryConverter() {
		return new CategoryRepositoryConverter();
	}

	@Bean
	public CategoryRestConverter createCategoryRestConverter() {
		return new CategoryRestConverter();
	}

	@Bean
	public CategoryServiceImpl createCategoriesServiceImpl() {
		return new CategoryServiceImpl(categoryRepository, createCategoryRepositoryConverter(), categoryService);
	}

	@Bean
	public GetAllCategoriesUseCaseImpl createGetAllCategoriesUseCase() {
		return new GetAllCategoriesUseCaseImpl(createCategoriesServiceImpl());
	}
	
	@Bean
	public CreateCategoryUseCaseImpl createCreateCategoryUseCase() {
		return new CreateCategoryUseCaseImpl(createCategoriesServiceImpl());
	}

	@Bean
	public UpdateCategoryUseCaseImpl updateCategoryUseCase() {
		return new UpdateCategoryUseCaseImpl(createCategoriesServiceImpl());
	}

	@Bean
	public DeleteACategoryUseCaseImpl deleteACategoryUseCase() {
		return new DeleteACategoryUseCaseImpl(createCategoriesServiceImpl());
	}

}