package com.bhx.map.configuration;

import com.bhx.map.persistence.impl.MapServiceImpl;
import com.bhx.map.ports.MapRepositoryService;
import com.bhx.product.delivery.converters.ProductMvcConverter;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapConfiguration {
    @Autowired
    private MapRepositoryService mapRepositoryService;
    @Bean
    public MapServiceImpl mapService() {
        return new MapServiceImpl();
    }

}
