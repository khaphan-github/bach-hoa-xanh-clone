package com.bhx.map.usecase;

import com.bhx.map.ports.MapRepositoryService;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class GetNearestAddressUseCaseImpl implements GetNearestAddressUsecase {
    private final MapRepositoryService mapRepositoryService;
    @Override
    public String excute(String sourceAddress, List<String> addresses) throws IOException, InterruptedException {
        return mapRepositoryService.getNearestAddress(sourceAddress, addresses);
    }
}
