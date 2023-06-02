package com.bhx.map.rest;

import com.bhx.map.GeocodingService;
import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class GeocodingServiceTest {
    @Autowired
    private GeocodingService geocodingService = new GeocodingService();

    @Test
    public void testGeocodeAddress() throws IOException, InterruptedException {
        String address = "1600 Amphitheatre Parkway, Mountain View, CA";
        Point point = GeocodingService.geocodeAddress(address);

        // Kiểm tra xem điểm tọa độ đã được trả về chưa
        Assert.assertNotNull(point);

        // Kiểm tra xem điểm tọa độ có chính xác không
        double expectedLatitude = 37.4220493;
        double expectedLongitude = -122.0840575;
        double epsilon = 0.0001; // Độ chính xác mong đợi

        Assert.assertEquals(expectedLatitude, point.getY(), epsilon);
        Assert.assertEquals(expectedLongitude, point.getX(), epsilon);
    }
}
