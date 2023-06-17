package com.bhx.map.rest;

import com.bhx.firebase.FirebaseService;
import com.bhx.map.persistence.impl.MapServiceImpl;
import com.bhx.map.ports.MapRepositoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.locationtech.jts.io.ParseException;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringJUnitConfig
@SpringBootTest
@AllArgsConstructor
public class DistanceCalculationTest {

    @Autowired
    private MapServiceImpl mapService;

    @Test
    public void testCalculateDistance() throws ParseException, IOException, InterruptedException {
        String address = "xã Trí Bình ,huyện Châu Thành,tỉnh Tây Ninh, Viet Nam";
        List<Double> point = mapService.geocodeAddress(address);

        String address2 = "Quận 10, Thành phố hồ chí minh, Việt Nam";
        List<Double> point2 = mapService.geocodeAddress(address2);

        double result = mapService.calculateDistance(point.get(1), point.get(0), point2.get(1), point2.get(0));
        Assert.assertNotNull(result);

    }

}
