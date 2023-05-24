package com.bhx.firebase.usecase;

import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.firebase.FirebaseService;
import com.bhx.firebase.GoogleCloudStorageConfig;
import com.google.cloud.storage.Storage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.google.cloud.storage.StorageOptions;

import javax.imageio.ImageIO;

public class UploadImagesProductImpl implements UploadImagesProduct {
    @Override
    public List<String> execute(List<Image> images) throws CategoryAlreadyExistException {
        List<String> publicUrls = new ArrayList<>();

        try {
            Storage storage = StorageOptions.getDefaultInstance().getService();
            FirebaseService firebaseService = new FirebaseService(storage);

            String bucketName = "bhx-clone.appspot.com";
            List<String> imageNames = new ArrayList<>();
            List<String> imagePaths = convertImagesToPaths(images);

            // Loop through the list of image objects and create a list of file names
            for (Image image : images) {
                // Save the file name
                String imageName = generateUniqueImageName(); // Provide a way to generate a unique file name
                imageNames.add(imageName);
            }

            // Upload the images to Firebase Storage
            publicUrls = firebaseService.uploadImages(bucketName, imagePaths, imageNames);

            // Print the public URLs
            for (String publicUrl : publicUrls) {
                System.out.println("Public URL: " + publicUrl);
            }

            // Delete the temporary image files (if necessary)
            deleteTempImageFiles(imagePaths);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return publicUrls;
    }

    private List<String> convertImagesToPaths(List<Image> images) throws IOException {
        List<String> imagePaths = new ArrayList<>();

        // Save each image to a temporary file and add the file path to the list
        for (Image image : images) {
            String tempImagePath = saveImageToTempFile(image); // Provide a way to save the image to a temporary file
            imagePaths.add(tempImagePath);
        }

        return imagePaths;
    }

    private String generateUniqueImageName() {
        // Generate a unique image name using a combination of timestamp and a random string
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return timestamp + "_" + randomString;
    }

    private String saveImageToTempFile(Image image) throws IOException {
        // Save the image to a temporary file
        String tempDir = System.getProperty("java.io.tmpdir");
        String fileName = generateUniqueImageName() + ".jpg";
        Path tempFilePath = Paths.get(tempDir, fileName);
        // Create a BufferedImage and draw the image onto it
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

// Write the image data to the temporary file
        try {
            ImageIO.write(bufferedImage, "jpg", tempFilePath.toFile());
        } catch (IOException e) {
            // Handle any exceptions that may occur during the image saving process
            throw new IOException("Failed to save the image to a temporary file.", e);
        }

        return tempFilePath.toString();
    }

    private void deleteTempImageFiles(List<String> imagePaths) {
        // Delete the temporary image files
        for (String imagePath : imagePaths) {
            File file = new File(imagePath);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
