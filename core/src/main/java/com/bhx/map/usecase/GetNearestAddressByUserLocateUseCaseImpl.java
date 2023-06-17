package com.bhx.map.usecase;

import com.bhx.map.ports.MapRepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class GetNearestAddressByUserLocateUseCaseImpl implements  GetNearestAddressByUserLocateUseCase{
    private final MapRepositoryService mapRepositoryService;
    @Override
    public String excute(double long1, double lat1) throws IOException, InterruptedException {
        return mapRepositoryService.getNearestAddressByUserLocate(lat1, long1);
    }
}
