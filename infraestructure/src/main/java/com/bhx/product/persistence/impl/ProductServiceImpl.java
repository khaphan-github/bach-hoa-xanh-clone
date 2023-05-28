package com.bhx.product.persistence.impl;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.entities.ProductEntity;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
public class ProductServiceImpl implements ProductRepositoryService {
    private final ProductRepository productRepository;
    private final ProductRepositoryConverter productRepositoryConverter;

    @Override
    public Collection<Product> getProducts() {
        return productRepository.findAll().stream().map(productRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<Product> getProductsPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> productEntityPage = productRepository.findAll(pageable);

        return productEntityPage.stream().map(productRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(String id) throws ProductNotFoundException {
        Optional<ProductEntity> productStored = productRepository.findById(id);
        if (!productStored.isPresent()) {
            throw new ProductNotFoundException();
        }
        return productRepositoryConverter.mapToEntity(productStored.get());
    }

    @Override
    public Collection<Product> getProductByCategoryId(String categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(productRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void saveProduct(final Product product) {
        productRepository.save(productRepositoryConverter.mapToTable(product));
    }

    @Override
    public boolean isExistProductByName(String name) {
        return !productRepository.findByName(name).isEmpty();
    }

    @Override
    public void inValidProductById(String id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setAvailable(false);
            productRepository.save(product.get());
        }
    }

    @Override
    public void saveMultipleProduct(List<Product> productList) {
        productRepository.saveAll(productList.stream().map(productRepositoryConverter::mapToTable).collect(Collectors.toList()));
    }
}
