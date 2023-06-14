package com.bhx.map.persistence.impl;

import com.bhx.map.ports.MapRepositoryService;
import com.bhx.storage.Storage;
import com.bhx.storage.persistence.impl.StorageServiceImpl;
import com.bhx.storage.ports.StorageRepositoryService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class MapServiceImpl implements MapRepositoryService {
    private final StorageRepositoryService storageRepositoryService;
    @Override
    public String getNearestAddress(String sourceAddress, List<String> addresses) throws IOException, InterruptedException {
        List<Double> sourceCoordinates = geocodeAddress(sourceAddress);
        if (sourceCoordinates == null) {
            return null; // Không tìm thấy tọa độ cho địa chỉ nguồn
        }

        Point sourcePoint = createPoint(sourceCoordinates.get(1), sourceCoordinates.get(0));
        if (sourcePoint == null) {
            return null; // Không thể tạo điểm từ tọa độ nguồn
        }

        String nearestAddress = null;
        double minDistance = Double.MAX_VALUE;

        for (String address : addresses) {
            List<Double> coordinates = geocodeAddress(address);
            if (coordinates != null) {
                Point point = createPoint(coordinates.get(1), coordinates.get(0));
                if (point != null) {
                    double distance = calculateDistance(sourcePoint.getY(), sourcePoint.getX(), point.getY(), point.getX());
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestAddress = address;
                    }
                }
            }
        }

        return nearestAddress;
    }

    @Override
    public String getNearestAddressByUserLocate(double latSource, double lonSource) throws IOException, InterruptedException {
        String nearestAddress = null;
        double minDistance = Double.MAX_VALUE;
        List<String> addresses = new ArrayList<>();
        List<Storage> allStorage = storageRepositoryService.getAllStorage();
        for (Storage storage : allStorage){
            addresses.add(storage.getAddress());
        }
        for (String address : addresses) {
            List<Double> coordinates = geocodeAddress(address);
            if (coordinates != null) {
                Point point = createPoint(coordinates.get(1), coordinates.get(0));
                if (point != null) {
                    double distance = calculateDistance(latSource,lonSource , point.getY(), point.getX());
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestAddress = address;
                    }
                }
            }
        }

        return nearestAddress;
    }

    @Override
    public List<Double> geocodeAddress(String address) throws IOException, InterruptedException {
        String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8.toString());
        String apiUrl = "https://nominatim.openstreetmap.org/search?format=geojson&q=" + encodedAddress;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();


        try {
            // Parse the response and extract the coordinates
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            JsonNode features = jsonNode.get("features");
            if (features != null && features.isArray() && features.size() > 0) {
                JsonNode firstFeature = features.get(0);
                JsonNode geometry = firstFeature.get("geometry");
                String wkt = geometry.toString();
                objectMapper = new ObjectMapper();
                Map<String, Object> wktMap = objectMapper.readValue(wkt, Map.class);
                return (List<Double>) wktMap.get("coordinates");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371; // Bán kính Trái Đất (đơn vị: kilômét)
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }



    private Point createPoint(double latitude, double longitude) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createPoint(new Coordinate(longitude, latitude));
    }
}
