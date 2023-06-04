package com.bhx.firebase.configuration;

import com.bhx.firebase.FirebaseService;
import com.bhx.firebase.persistence.impl.FirebaseServiceImpl;
import com.bhx.product.persistence.impl.ProductServiceImpl;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfiguration {
    @Bean
    public FirebaseServiceImpl firebaseServiceImpl() {
        return new FirebaseServiceImpl();
    }

    public  Storage storage;
    @Bean
    public FirebaseService firebaseService(){return new FirebaseService(storage);};
}
