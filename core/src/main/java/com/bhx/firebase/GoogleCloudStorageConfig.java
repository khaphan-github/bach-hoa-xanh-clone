package com.bhx.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GoogleCloudStorageConfig {
    public static Storage initialize() throws IOException {
        // Chuỗi JSON chứa thông tin xác thực
        String jsonContent = "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"bhx-clone\",\n" +
                "  \"private_key_id\": \"d5cf8bea3fd78c4fa6a8a919bd6785d4086f221d\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC9g6Mh5xnllCwP\\nfHb8hs8NhEoJp8tTfaLd2u0W3lzjRemw8h2Hwhmp6rjiZH7ts9UG57Vst8JoED59\\n2lMT4Oz66J5IslAZDGyGb1PZBbEcQ0R9koYEQgPBzkMvH6BNXvhOcM3O4mr4z/VV\\n9xA6fIPsM7reU0hacI1ruHV1zZiH+oc0FobS4z4qMZun90+WNNEot5C3EMr0wEo/\\nAoL7oqUckPcH47FxAJrT4FDL3/X57lEVgO4v7qxrMc8J2633ZTXe16WuVS2BvY7M\\nn8cslEM/ZQVp72iekE3pYIu962+6CajsRdli1YSFlD+gsrdw6b5rdhtOQr+RHV1r\\nmYh9qah7AgMBAAECggEABmSh71tZ8suK/vdpFioVYwnYQOIhsvkqh4cX920HP31/\\ncteAFTEq53dXxv9dOXdBvkq5F+f3uBtQLbOx7ho+NFVTkvU89tNbTTUFOZgpD4sv\\nYiMRaqRazGzBCckXLHUB4GI1dyoJMh07KVa9JpPxFAScubJKibkr9CXUBJDWeUPJ\\n8bftQhGOej8+NbabMpiQEu6M63v5vH1phGvXtvFOIFNDNXjZtd6qG6toqPiJExP2\\n9c9US69Y7b/lWUnQ8kNMpnXmRNbYkP5AXsOrE9NmEe/aQxnetVNQuwc0GrDnBzkF\\nYYR9JexdB8zvR9MgGJuH7zPPDYXTwnFpItjc9Oa0eQKBgQDjmxIbdkxi4PeW2cWV\\ntRiSYJt6UODH1UnWDJlLMPtuJYOsqnRKruaGGV1OzuMWhZ8ekpv4KRccw2VGl2K/\\niUcj30B4gfUJ//SnlEEeOyzyTYn9bFi4zlG0tlSdyPh8b1DhwQ8IYUdmfPejDpbc\\n6TaJHKHNM9eqsonapi6KhpZh6QKBgQDVKA5wL9tJAPcdTQJlbFdRnjd4c/DDcMVn\\npxHf6PM+krDw9u6Kb4lNmjQTXwXcZFg5ivxWzyD69yg18TpRXdHtR/SnMSX7k605\\nn+xZ/el65npqyXxO1UdfeaZOMYIagxaT9t8LjMG/S63zsc752DNKTCNN9+MbehsO\\no5s5M5P0wwKBgQChxPHVuvsHvEW9XgLlKNXSE//tq9ZXsezMyh+aJbJO0zMHYg9N\\nlYoa/aQoAzu8IjS6EhHxC6N1uhsdVTPGVtfNUzwLarKy7M0C3oh56C1F+n59NKjK\\nkTnZa04w50pVhvjBu+nnVtzcpy2LIy9uzAMK6OLHanV6yXLZiQvDQW1ZIQKBgQDM\\nHVh+G4WsCc2Y9FZ4EuAm2xAZO0TxkjqmgDjApozPfZ8MkBlq3VWoxyJY7mRpYHmP\\nWMU8x4m4aRbLWN1UbzgINSBVPd42Y3q8tKSapGeA9dWCDsEHqHp5Nb+IHyaMBr2H\\nIR8DK12Ytnqz4q/lVh//ZJtmHRsQA8SHJyoMA5UKCwKBgQDhyDCxgRJJhPhU8AzA\\nKMdw1MHUpb2Fj8ipKKs+3HL6OcOKo/Q2enFnMMuH1pQPS+jIEVnV9Vyq7Xcg5ICT\\n3jOxUBwljs1KrttWzRis/46+lznsIGdnMBV3abisX94XfLJnXt+aW+BWYvblMA6p\\nZ3mlw6kHRFyCfFrAAvwC9ODDvw==\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-971x1@bhx-clone.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"107375721529813526803\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-971x1%40bhx-clone.iam.gserviceaccount.com\"\n" +
                "}";

        // Tạo đối tượng GoogleCredentials từ chuỗi JSON
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new ByteArrayInputStream(jsonContent.getBytes()));

        // Xây dựng đối tượng StorageOptions với thông tin xác thực
        StorageOptions options = StorageOptions.newBuilder().setCredentials(credentials).build();

        // Khởi tạo và trả về đối tượng Storage
        return options.getService();
    }
}
