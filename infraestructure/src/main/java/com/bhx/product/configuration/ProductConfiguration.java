package com.bhx.product.configuration;

import com.bhx.map.persistence.impl.MapServiceImpl;
import com.bhx.map.ports.MapRepositoryService;
import com.bhx.map.usecase.GetNearestAddressByUserLocateUseCase;
import com.bhx.map.usecase.GetNearestAddressByUserLocateUseCaseImpl;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.product.usecase.*;
import com.bhx.storage.persistence.converter.StorageRepositoryConverter;
import com.bhx.storage.persistence.impl.StorageServiceImpl;
import com.bhx.storage.persistence.repositories.StorageRepository;
import com.bhx.storage.ports.StorageRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "KhaPhan" on 17-May-23
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
    public ProductRepositoryConverter productRepositoryConverter() {
        return new ProductRepositoryConverter();
    }

    @Bean
    public ProductServiceImpl productService() {
        return new ProductServiceImpl(this.productRepository, productRepositoryConverter());
    }

    @Bean
    public GetAllProductsUseCaseImpl getAllProductsUseCase() {
        return new GetAllProductsUseCaseImpl(productService());
    }

    @Bean
    public CreateProductUseCaseImpl createProductUseCase() {
        return new CreateProductUseCaseImpl(productService());
    }

    @Bean
    public GetOneProductUseCaseImpl getOneProductUseCase() {
        return new GetOneProductUseCaseImpl(productService());
    }

    @Bean
    public InValidProductUseCaseImpl inValidProductUseCase() {
        return new InValidProductUseCaseImpl(productService());
    }

    @Bean
    public GetAllProductPagingUseCaseImpl getAllProductPagingUseCase() {
        return new GetAllProductPagingUseCaseImpl(productService());
    }

    @Autowired
    private StorageRepository storageRepository;

    public StorageRepositoryConverter storageRepositoryConverter() {
        return new StorageRepositoryConverter();
    }

    public StorageRepositoryService storageService() {
        return new StorageServiceImpl(storageRepository, storageRepositoryConverter());
    }

    public MapRepositoryService mapService() {
        return new MapServiceImpl(storageService(), storageRepository);
    }
    @Bean
    public GetNearestAddressByUserLocateUseCase getNearestAddressByUserLocateUseCase() {
        return new GetNearestAddressByUserLocateUseCaseImpl(mapService());
    }



}
