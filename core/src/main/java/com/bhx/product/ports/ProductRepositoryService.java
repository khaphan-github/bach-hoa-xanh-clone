package com.bhx.product.ports;

import com.bhx.category.Category;
import com.bhx.product.Product;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public interface ProductRepositoryService {
    public Collection<Product> getProducts();

    public Collection<Product> getProductsPaging(int page, int size);

    public Product getProductById(String id);

    public Product getProductByCategoryId(String categoryId);

    public void saveProduct(Product product);

    public boolean isExistProductByName(String name);

    public void inValidProductById(String id);
}
