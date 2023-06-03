package com.bhx.map.rest;

import com.bhx.map.GeocodingService;
import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.io.IOException;
import java.util.List;

public class DistanceCalculationTest {

    private GeocodingService geocodingService = new GeocodingService();
    @Test
    public void testCalculateDistance() throws ParseException, IOException, InterruptedException {
        String address = "xã Trí Bình ,huyện Châu Thành,tỉnh Tây Ninh, Viet Nam";
        List<Double> point = GeocodingService.geocodeAddress(address);

        String address2 = "Quận 10, Thành phố hồ chí minh, Việt Nam";
        List<Double> point2 = GeocodingService.geocodeAddress(address2);

        double result = GeocodingService.calculateDistance(point.get(1), point.get(0), point2.get(1), point2.get(0));
        Assert.assertNotNull(result);

    }

}
