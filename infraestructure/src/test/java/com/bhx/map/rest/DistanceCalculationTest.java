package com.bhx.map.rest;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class DistanceCalculationTest {

    @Test
    public void testCalculateDistance() throws ParseException {
        GeometryFactory geometryFactory = new GeometryFactory();
        WKTReader reader = new WKTReader(geometryFactory);

        // Tạo các điểm tọa độ
        Point origin = (Point) reader.read("POINT(40.712778 -74.005974)");
        Point destination = (Point) reader.read("POINT(34.052235 -118.243683)");

        // Tính khoảng cách
        double distance = calculateDistance(origin, destination);

        // So sánh với giá trị mong đợi
        double expectedDistance = 3930142.43; // Khoảng cách tính toán từ công cụ đo khoảng cách
        double epsilon = 0.01; // Độ chính xác mong đợi

        Assert.assertEquals(expectedDistance, distance, epsilon);
    }

    private double calculateDistance(Point origin, Point destination) {
        Coordinate originCoord = origin.getCoordinate();
        Coordinate destCoord = destination.getCoordinate();
        return originCoord.distance(destCoord);
    }
}
