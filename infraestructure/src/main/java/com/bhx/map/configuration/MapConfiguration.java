package com.bhx.map.configuration;

import com.bhx.map.persistence.impl.MapServiceImpl;
import com.bhx.map.ports.MapRepositoryService;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.product.ports.ProductRepositoryService;
import com.bhx.storage.persistence.converter.StorageRepositoryConverter;
import com.bhx.storage.persistence.impl.StorageServiceImpl;
import com.bhx.storage.persistence.repositories.StorageRepository;
import com.bhx.storage.ports.StorageRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapConfiguration {
    @Autowired
    private StorageRepository storageRepository;

    public StorageRepositoryConverter storageRepositoryConverter() {
        return new StorageRepositoryConverter();
    }

    public StorageRepositoryService storageService() {
        return new StorageServiceImpl(storageRepository, storageRepositoryConverter());
    }


    @Bean
    public MapRepositoryService mapService() {
        return new MapServiceImpl(storageService(), storageRepository);
    }

}
