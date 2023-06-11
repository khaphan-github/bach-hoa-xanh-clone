package com.bhx.map.rest;

import com.bhx.map.persistence.impl.MapServiceImpl;
import com.bhx.map.ports.MapRepositoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class GetNearestAddressTest {
    @Autowired
    public  MapRepositoryService mapRepositoryService;

    @Test
    public void testFindNearestAddress() throws IOException, InterruptedException {
        mapRepositoryService = new MapServiceImpl();
        String address1 = "xã Trí Bình ,huyện Châu Thành,tỉnh Tây Ninh, Viet Nam";
        String address2 = "Quận 10, Thành phố Hồ Chí Minh, Việt Nam";
        String addressSource = "Thành phố Vũng Tàu, Việt Nam";

        List<String> addresses = Arrays.asList(address1, address2);
        String nearestAddress = mapRepositoryService.getNearestAddress(addressSource, addresses);

        Assert.assertEquals(address2, nearestAddress);
    }
}
