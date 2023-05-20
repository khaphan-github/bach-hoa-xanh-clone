package com.bhx.firebase;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Blob;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FirebaseService {
    private Storage storage;

    public FirebaseService(Storage storage) {
        this.storage = storage;
    }

    public void uploadImage(String bucketName, String imagePath, String imageName) throws IOException {
        // Tạo đối tượng BlobId để định danh tệp tin trên Firebase Storage
        BlobId blobId = BlobId.of(bucketName, imageName);

        // Tạo đối tượng BlobInfo với BlobId và các thông tin khác
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        // Tải lên tệp tin lên Firebase Storage
        Blob blob = storage.create(blobInfo, Files.readAllBytes(Paths.get(imagePath)));

        // Lấy URL công khai của tệp tin đã tải lên
        String publicUrl = blob.getMediaLink();

        // In ra URL công khai
        System.out.println("Public URL: " + publicUrl);
    }
}
