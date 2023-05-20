package com.bhx.product.configuration;

import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.product.usecase.GetAllProductsUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
@Configuration
public class ProductConfiguration {
    @Autowired
    private ProductRepository productRepository;

    @Bean
    public ProductMvcConverter productMvcConverter() {
        return new ProductMvcConverter();
    }
    @Bean
    ProductRepositoryConverter productRepositoryConverter() {
        return new ProductRepositoryConverter();
    }

    @Bean
    public ProductServiceImpl productService() {
        return new ProductServiceImpl(productRepository, productRepositoryConverter());
    }

    @Bean
    public GetAllProductsUseCaseImpl getAllProductsUseCase() {
        return new GetAllProductsUseCaseImpl(productService());
    }
}