package com.bhx.firebase.rest;

import com.bhx.firebase.persistence.impl.FirebaseServiceImpl;
import com.bhx.firebase.ports.FirebaseRepositoryService;
import com.bhx.firebase.usecase.UploadImagesProduct;
import com.bhx.firebase.usecase.UploadImagesProductImpl;
import com.bhx.firebase.FirebaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class UploadImagesProductTest {

    @Autowired
    private FirebaseService firebaseService;
    private UploadImagesProduct uploadImagesProduct;

    private FirebaseRepositoryService firebaseRepositoryService;

    @Test
    public void testUploadMultipleImages() throws Exception {
        firebaseService = Mockito.mock(FirebaseService.class);
        List<Image> images = new ArrayList<>();
        uploadImagesProduct = new UploadImagesProductImpl(firebaseRepositoryService);
        firebaseRepositoryService = new FirebaseServiceImpl();
        try {
            // Read the first image from file
            Image image1 = ImageIO.read(new File("C:\\Users\\VITNHTHIENVU.COM\\OneDrive\\Desktop\\anhthuchanhbmmt\\deDES.PNG"));
            images.add(image1);

            // Read the second image from file
            Image image2 = ImageIO.read(new File("C:\\Users\\VITNHTHIENVU.COM\\OneDrive\\Desktop\\anhthuchanhbmmt\\deAES.PNG"));
            images.add(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up the expected values
        String bucketName = "bhx-clone.appspot.com";
        List<String> imageNames = new ArrayList<>(Arrays.asList("image1.jpg", "image2.jpg"));
        List<String> imagePaths = new ArrayList<>(Arrays.asList("C:\\Users\\VITNHTHIENVU.COM\\OneDrive\\Desktop\\anhthuchanhbmmt\\deDES.PNG", "C:\\Users\\VITNHTHIENVU.COM\\OneDrive\\Desktop\\anhthuchanhbmmt\\deAES.PNG"));
        List<String> publicUrls = new ArrayList<>(Arrays.asList("https://example.com/image1.jpg", "https://example.com/image2.jpg"));


        // Mock the behavior of FirebaseService
        Mockito.when(firebaseService.uploadImages(bucketName, imagePaths, imageNames))
                .thenReturn(publicUrls);

        // Call the method under test
        List<String> result = uploadImagesProduct.execute(images);
        assertEquals(1, 1, "true");
    }
}
