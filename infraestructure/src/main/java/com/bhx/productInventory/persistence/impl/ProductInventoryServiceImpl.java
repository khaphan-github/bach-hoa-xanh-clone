package com.bhx.productInventory.persistence.impl;

import com.bhx.product.Product;
import com.bhx.product.exception.PagingWrongFormat;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.persistence.entities.ProductEntity;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.product.ports.ProductRepositoryService;
import com.bhx.productInventory.ProductInventory;
import com.bhx.productInventory.persistence.converter.ProductInventoryRepositoryConverter;

import com.bhx.productInventory.persistence.entities.ProductInventoryEntity;
import com.bhx.productInventory.persistence.repositories.ProductInventoryRepository;

import com.bhx.productInventory.ports.ProductInventoryRepositoryService;
import com.bhx.storage.Storage;
import com.bhx.storage.persistence.entities.StorageEntity;
import com.bhx.storage.ports.StorageRepositoryService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductInventoryServiceImpl implements ProductInventoryRepositoryService {

    private final ProductInventoryRepository productInventoryRepository;
    private final ProductInventoryRepositoryConverter productInventoryRepositoryConverter;
    private final ProductRepositoryService productRepositoryService;
    @Override
    public boolean saveProductInventory(ProductInventory productInventory) {
        productInventoryRepository.save(productInventoryRepositoryConverter.mapToTable(productInventory));
        return true;
    }



    @Override
    public List<Product> getProductByStorageId(String storageId) throws ProductNotFoundException {
        List<String> productIds = productInventoryRepository.findProductIdsByStorageId(storageId);
        List<Product> product = new ArrayList<>();
        for (String productId : productIds) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(productId, JsonObject.class);
            productId = jsonObject.get("productId").getAsString();
            product.add(productRepositoryService.getProductById(productId));
        }
        return product;
    }

    @Override
    public Product  getAProductByStorageId(String storageId, String productId) throws ProductNotFoundException {
        Product productGet = new Product();
        List<String> productIds = productInventoryRepository.findProductIdsByStorageId(storageId);
        for (String productIdGet : productIds) {
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(productIdGet, JsonObject.class);
                productIdGet = jsonObject.get("productId").getAsString();
                if (productIdGet.equalsIgnoreCase(productId))
                {
                    productGet = productRepositoryService.getProductById(productId);
                    int inventory = productInventoryRepository.findByStorageIdAndProductId(storageId, productId).getInventory();
                    productGet.setInventory(inventory);
                }
        }

        return productGet;
    }

    @Override
    public ProductInventory getProductInventoryByStorageIdAndProductId(String storageId, String productId) {
        return productInventoryRepository.findByStorageIdAndProductId(storageId, productId);
    }

    @Override
    public Collection<Product> getAllProductWithPaging(int page, int size, String storageId) throws PagingWrongFormat, ProductNotFoundException {
        List<Product> productList = new ArrayList<>();
        List<String> productIds = productInventoryRepository.findProductIdsByStorageId(storageId);
        Pageable pageable = PageRequest.of(page, size);
        int startIdx = (int) pageable.getOffset();
        int endIdx = Math.min(startIdx + pageable.getPageSize(), productIds.size());
        List<String> productIdsPage = productIds.subList(startIdx, endIdx);

        for (String productIdGet : productIdsPage) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(productIdGet, JsonObject.class);
            productIdGet = jsonObject.get("productId").getAsString();
                Product productGet = productRepositoryService.getProductById(productIdGet);
                int inventory = productInventoryRepository.findByStorageIdAndProductId(storageId, productIdGet).getInventory();
                productGet.setInventory(inventory);
                productList.add(productGet);
        }

        return productList;
    }

    @Override
    public Product getAProductDetail(String StorageId, String ProductId) throws ProductNotFoundException {
        Product productGet = productRepositoryService.getProductById(ProductId);
        int inventory = productInventoryRepository.findByStorageIdAndProductId(StorageId, ProductId).getInventory();
        productGet.setInventory(inventory);
        return productGet;
    }


}
