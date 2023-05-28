package com.bhx.product.ports;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductNotFoundException;

import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 13-May-23
 */
public interface ProductRepositoryService {
    public Collection<Product> getProducts();

    public Collection<Product> getProductsPaging(int page, int size);

    public Product getProductById(String id) throws ProductNotFoundException;

    public Collection<Product> getProductByCategoryId(String categoryId);

    public void saveProduct(Product product);

    public boolean isExistProductByName(String name);

    public void inValidProductById(String id);

    public void saveMultipleProduct(List<Product> productList);
}
