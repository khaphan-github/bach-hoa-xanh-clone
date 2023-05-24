package com.bhx;

import com.bhx.firebase.FirebaseService;
import com.bhx.firebase.GoogleCloudStorageConfig;
import com.google.cloud.storage.Storage;
import com.bhx.webconfig.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
