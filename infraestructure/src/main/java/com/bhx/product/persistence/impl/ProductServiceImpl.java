package com.bhx.product.persistence.impl;

import com.bhx.product.Product;
import com.bhx.product.persistence.converter.ProductRepositoryConverter;
import com.bhx.product.persistence.repositories.ProductRepository;
import com.bhx.product.ports.ProductRepositoryService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
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
        return productRepository.findAll().stream()
                .map(productRepositoryConverter::mapToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Product> getProductsPaging(int page, int size) {
        return null;
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public Product getProductByCategoryId(String categoryId) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public boolean isExistProductByName(String name) {
        return false;
    }

    @Override
    public void inValidProductById(String id) {

    }
}
