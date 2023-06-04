package com.bhx.firebase;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FirebaseService {
    private Storage storage;

    public FirebaseService(Storage storage) {
        this.storage = storage;
    }

    public List<String> uploadImages(String bucketName, List<String> imagePaths, List<String> imageNames) throws IOException {
        List<String> publicUrls = new ArrayList<>();
        for (int i = 0; i < imagePaths.size(); i++) {
            String imagePath = imagePaths.get(i);
            String imageName = imageNames.get(i);

            // Tạo đối tượng BlobId để định danh tệp tin trên Firebase Storage
            BlobId blobId = BlobId.of(bucketName, imageName);

            // Tạo đối tượng BlobInfo với BlobId và các thông tin khác
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                    .setContentType("image/jpeg") // Thay đổi loại nội dung thành hình ảnh
                    .build();

            // Tải lên tệp tin lên Firebase Storage
            Blob blob = storage.create(blobInfo, Files.readAllBytes(Paths.get(imagePath)));

            // Lấy URL công khai của tệp tin đã tải lên
            String publicUrl = "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/" + imageName + "?alt=media";

            // Add the public URL to the list
            publicUrls.add(publicUrl);

            // In ra URL công khai
            System.out.println("Public URL: " + publicUrl);
        }
        return publicUrls;
    }


}
