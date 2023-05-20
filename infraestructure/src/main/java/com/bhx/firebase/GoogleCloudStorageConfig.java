package com.bhx.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GoogleCloudStorageConfig {
    public static Storage initialize() throws IOException {
        Path filePath = Paths.get("C:\\Users\\VITNHTHIENVU.COM\\OneDrive\\Documents\\bach-hoa-xanh-clone\\infraestructure\\src\\main\\java\\com\\bhx\\firebase\\secretKey\\secretKey.json");
        FileInputStream serviceAccount = new FileInputStream(filePath.toFile());

        StorageOptions options = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return options.getService();
    }
}
