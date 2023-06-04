package com.bhx;

import com.bhx.firebase.GoogleCloudStorageConfig;
import com.google.cloud.storage.Storage;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        BasicConfigurator.configure();
    }
}
