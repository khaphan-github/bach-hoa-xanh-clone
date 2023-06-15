package com.bhx.map.rest;

import com.bhx.map.persistence.impl.MapServiceImpl;
import com.bhx.map.ports.MapRepositoryService;
import com.bhx.productInventory.persistence.impl.ProductInventoryServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
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
public class GetNearestAddressByUserLocateTest {

    @Autowired
    private MapServiceImpl mapService;

    @Test
    public void testFindNearestAddress() throws IOException, InterruptedException {
        String nearestAddress = mapService.getNearestAddressByUserLocate(10.8058688, 106.6438673);
        Assert.assertEquals("Quận 10, Thành Phố Hồ Chí Minh", nearestAddress);
    }
}
