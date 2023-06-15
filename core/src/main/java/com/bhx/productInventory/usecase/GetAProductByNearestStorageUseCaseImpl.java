package com.bhx.productInventory.usecase;

import com.bhx.map.ports.MapRepositoryService;
import com.bhx.map.usecase.GetNearestAddressByUserLocateUseCase;
import com.bhx.product.Product;
import com.bhx.productInventory.ProductInventory;
import com.bhx.productInventory.ports.ProductInventoryRepositoryService;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class GetAProductByNearestStorageUseCaseImpl implements  GetAProductByNearestStorageUseCase{
    private final ProductInventoryRepositoryService inventoryRepositoryService;
    private final GetNearestAddressByUserLocateUseCase getNearestAddressByUserLocateUseCase;

    @Override
    public Product excute(double lon, double lat) throws IOException, InterruptedException {
        String addressNearest = getNearestAddressByUserLocateUseCase.excute(lon, lat);
        return null;
    }
}
