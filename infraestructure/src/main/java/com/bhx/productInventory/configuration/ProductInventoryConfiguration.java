package com.bhx.productInventory.configuration;

import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.product.ports.ProductRepositoryService;
import com.bhx.product.usecase.GetAllProductsUseCaseImpl;
import com.bhx.product.usecase.GetOneProductUseCase;
import com.bhx.product.usecase.GetOneProductUseCaseImpl;
import com.bhx.productInventory.persistence.converter.ProductInventoryRepositoryConverter;
import com.bhx.productInventory.persistence.impl.ProductInventoryServiceImpl;
import com.bhx.productInventory.persistence.repositories.ProductInventoryRepository;
import com.bhx.storage.persistence.converter.StorageRepositoryConverter;
import com.bhx.storage.persistence.impl.StorageServiceImpl;
import com.bhx.storage.persistence.repositories.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductInventoryConfiguration {
    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public ProductInventoryRepository productInventoryRepository() {
        return new ProductInventoryServiceImpl();
    }

    @Bean
    public ProductInventoryRepositoryConverter productInventoryRepositoryConverter() {
        return new ProductInventoryRepositoryConverter();
    }

    @Bean
    public ProductRepositoryConverter productRepositoryConverter() {
        return new ProductRepositoryConverter();
    }

    @Bean
    public ProductRepositoryService productRepositoryService() {
        return new ProductServiceImpl(productRepository, productRepositoryConverter());
    }

    @Bean
    public ProductServiceImpl productService() {
        return new ProductServiceImpl(productRepository, productRepositoryConverter());
    }

    @Bean
    public ProductInventoryServiceImpl productInventoryService() {
        return new ProductInventoryServiceImpl(
                productInventoryRepository(),
                productInventoryRepositoryConverter(),
                productRepositoryService()
        );
    }
}
