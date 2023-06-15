package com.bhx.map.ports;

import com.bhx.storage.Storage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface MapRepositoryService {
    public String getNearestAddress(String sourceAddress, List<String> addresses) throws IOException, InterruptedException;

    public String getNearestAddressByUserLocate(double latSource, double lonSource) throws IOException, InterruptedException;
    public List<Double> geocodeAddress(String address) throws IOException, InterruptedException;

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2);

}
