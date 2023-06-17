package com.bhx.map.usecase;

import java.io.IOException;
import java.util.List;

public interface GetNearestAddressUsecase {

    public String excute(String sourceAddress, List<String> addresses) throws IOException, InterruptedException;
}
