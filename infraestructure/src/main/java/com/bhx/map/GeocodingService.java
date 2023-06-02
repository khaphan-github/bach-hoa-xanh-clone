package com.bhx.map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeocodingService {
    public static Point geocodeAddress(String address) throws IOException, InterruptedException {
        String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8.toString());
        String apiUrl = "https://nominatim.openstreetmap.org/search?format=geojson&q=" + encodedAddress;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        Point point = null;

        try {
            // Parse the response and extract the coordinates
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            JsonNode features = jsonNode.get("features");
            if (features != null && features.isArray() && features.size() > 0) {
                JsonNode firstFeature = features.get(0);
                JsonNode geometry = firstFeature.get("geometry");
                String wkt = geometry.toString();

                WKTReader wktReader = new WKTReader(new GeometryFactory());
                point = (Point) wktReader.read(wkt);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return point;
    }
}
