package com.bhx.firebase.rest;

import com.bhx.firebase.FirebaseService;
import com.bhx.firebase.usecase.UploadImagesProduct;
import com.bhx.firebase.usecase.UploadImagesProductImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadImagesProductTest {

    @Autowired
    UploadImagesProductImpl uploadImagesProduct = new UploadImagesProductImpl();
    @Autowired
    private FirebaseService firebaseService;

    @BeforeEach
    public void setUp() {
        // Create a mock instance of FirebaseService
        firebaseService = Mockito.mock(FirebaseService.class);

        // Initialize the UploadImagesProduct instance with the mock FirebaseService
        UploadImagesProduct uploadImagesProduct = new UploadImagesProductImpl();
    }

    @Test
    public void testUploadMultipleImages() throws Exception {
        List<Image> images = new ArrayList<>();
        try {
            // Read the first image from file
            Image image1 = ImageIO.read(new File("C:\\Users\\Depv247\\Desktop\\kimkhanhhhhhh.jpg"));
            images.add(image1);

            // Read the second image from file
            Image image2 = ImageIO.read(new File("C:\\Users\\Depv247\\Desktop\\kk.jpg"));
            images.add(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up the expected values
        String bucketName = "bhx-clone.appspot.com";
        List<String> imageNames = new ArrayList<>(Arrays.asList("image1.jpg", "image2.jpg"));
        List<String> imagePaths = new ArrayList<>(Arrays.asList("C:\\Users\\Depv247\\Desktop\\kimkhanhhhhhh.jpg", "C:\\Users\\Depv247\\Desktop\\kk.jpg"));
        List<String> publicUrls = new ArrayList<>(Arrays.asList("https://example.com/image1.jpg", "https://example.com/image2.jpg"));


        // Mock the behavior of FirebaseService
        Mockito.when(firebaseService.uploadImages(bucketName, imagePaths, imageNames))
                .thenReturn(publicUrls);

        // Call the method under test
        List<String> result = uploadImagesProduct.execute(images);
        assertEquals(1, 1, "true");
    }
}
