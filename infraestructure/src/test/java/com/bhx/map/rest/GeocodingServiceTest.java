package com.bhx.map.rest;

import com.bhx.map.GeocodingService;
import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class GeocodingServiceTest {
    private GeocodingService geocodingService = new GeocodingService();

    @Test
    public void testGeocodeAddress() throws IOException, InterruptedException {
        String address = "xã Trí Bình ,huyện Châu Thành,tỉnh Tây Ninh, Viet Nam";
        List<Double> point = GeocodingService.geocodeAddress(address);

        // Kiểm tra xem điểm tọa độ đã được trả về chưa
        Assert.assertNotNull(point);

        // Kiểm tra xem điểm tọa độ có chính xác không
        double expectedLatitude = 11.3127189;
        double expectedLongitude = 106.0228282;
        double epsilon = 0.1; // Độ chính xác mong đợi
        Assert.assertEquals(expectedLatitude, point.get(1), epsilon);
        Assert.assertEquals(expectedLongitude, point.get(0), epsilon);
    }
}
