package com.bhx.map.usecase;

import java.io.IOException;
import java.util.List;

public interface GetNearestAddressByUserLocateUseCase {
    public String excute(double long1, double lat1) throws IOException, InterruptedException;
}
