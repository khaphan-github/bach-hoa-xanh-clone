package com.bhx.map.rest;

import com.bhx.map.persistence.impl.MapServiceImpl;
import com.bhx.map.ports.MapRepositoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class GeocodingServiceTest {

    @Autowired
    private  MapRepositoryService mapRepositoryService;

    @Test
    public void testGeocodeAddress() throws IOException, InterruptedException {
        mapRepositoryService = new MapServiceImpl();
        String address = "xã Trí Bình ,huyện Châu Thành,tỉnh Tây Ninh, Viet Nam";
        List<Double> point = mapRepositoryService.geocodeAddress(address);

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
