package com.bhx.map.rest;

import com.bhx.map.GeocodingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class GetNearestAddressTest {
    private GeocodingService geocodingService = new GeocodingService();

    @Test
    public void testFindNearestAddress() throws IOException, InterruptedException {
        String address1 = "xã Trí Bình ,huyện Châu Thành,tỉnh Tây Ninh, Viet Nam";
        String address2 = "Quận 10, Thành phố Hồ Chí Minh, Việt Nam";
        String addressSource = "Thành phố Vũng Tàu, Việt Nam";

        GeocodingService geocodingService = new GeocodingService();

        List<String> addresses = Arrays.asList(address1, address2);
        String nearestAddress = geocodingService.findNearestAddress(addressSource, addresses);

        Assert.assertEquals(address2, nearestAddress);
    }
}
