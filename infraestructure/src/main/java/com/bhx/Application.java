package com.bhx;

import com.bhx.firebase.FirebaseService;
import com.bhx.firebase.GoogleCloudStorageConfig;
import com.google.cloud.storage.Storage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        try {
            Storage storage = GoogleCloudStorageConfig.initialize();
            FirebaseService firebaseService = new FirebaseService(storage);

            List<String> imagePaths = Arrays.asList(
                    "C:\\Users\\Depv247\\Desktop\\kk.jpg",
                    "C:\\Users\\Depv247\\Desktop\\kimkhanhhhhhh.jpg"
            );
            List<String> imageNames = Arrays.asList(
                    "kk.jpg",
                    "kimkhanhhhhhh.jpg"
            );

            String bucketName = "bhx-clone.appspot.com";

            firebaseService.uploadImages(bucketName, imagePaths, imageNames);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
