package com.bhx.productInventory.usecase;

import com.bhx.map.usecase.GetNearestAddressByUserLocateUseCase;
import com.bhx.product.Product;
import com.bhx.product.exception.PagingWrongFormat;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.productInventory.ports.ProductInventoryRepositoryService;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
public class GetAllProductByUserLocateUseCaseImpl implements  GetAllProductByUserLocateUseCase {
    private final ProductInventoryRepositoryService inventoryRepositoryService;
    private final GetNearestAddressByUserLocateUseCase getNearestAddressByUserLocateUseCase;
    @Override
    public Collection<Product> excute(int page, int size, double lon, double lat) throws PagingWrongFormat, ProductNotFoundException, IOException, InterruptedException {
        String nearestId = getNearestAddressByUserLocateUseCase.excute(lon, lat);
        return inventoryRepositoryService.getAllProductWithPaging(page, size, nearestId);
    }
}
