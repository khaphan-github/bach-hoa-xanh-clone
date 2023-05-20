package com.bhx;

import com.bhx.firebase.FirebaseService;
import com.bhx.firebase.GoogleCloudStorageConfig;
import com.google.cloud.storage.Storage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        try {
            Storage storage = GoogleCloudStorageConfig.initialize();
            FirebaseService firebaseService = new FirebaseService(storage);

            String imagePath = "C:\\Users\\VITNHTHIENVU.COM\\OneDrive\\Documents\\anhdamhoi\\test.jpg";
            String bucketName = "bhx-clone.appspot.com";
            String fileName = "image.jpg";

            firebaseService.uploadImage(bucketName, imagePath, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
