package com.bhx.storage.configuration;

import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.productInventory.usecase.GetAllProductByUserLocateUseCase;
import com.bhx.productInventory.usecase.GetAllProductByUserLocateUseCaseImpl;
import com.bhx.storage.persistence.converter.StorageRepositoryConverter;
import com.bhx.storage.persistence.impl.StorageServiceImpl;
import com.bhx.storage.persistence.repositories.StorageRepository;
import com.bhx.storage.ports.StorageRepositoryService;
import com.bhx.storage.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfiguration {
    @Autowired
    private StorageRepository storageRepository;

    @Bean
    public StorageRepositoryConverter storageRepositoryConverter() {
        return new StorageRepositoryConverter();
    }
    @Bean
    public StorageRepositoryService storageService() {
        return new StorageServiceImpl(this.storageRepository, storageRepositoryConverter());
    }

    @Bean
    public GetAllStorageUsecase getAllStorageUsecase() {
        return new GetAllStorageUsecaseImpl(storageService());
    }

    @Bean
    public CreateAStorageUseCase createAStorageUseCase() {
        return new CreateAStorageUseCaseImpl(storageService());
    }

    @Bean
    public EditAStorageUseCase editAStorageUseCase() {
        return new EditAStorageUseCaseImpl(storageService());
    }
}
