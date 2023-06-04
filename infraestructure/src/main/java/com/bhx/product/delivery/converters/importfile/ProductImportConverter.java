package com.bhx.product.delivery.converters.importfile;

import com.bhx.global.shared.RestConverter;
import com.bhx.product.Product;

/**
 * @author "KhaPhan" on 22-May-23
 * @project clean-architecture
 */
public class ProductImportConverter implements RestConverter<ProductFromFile, Product> {
    @Override
    public Product mapToEntity(final ProductFromFile productFromFile) {
        return new Product();
    }

    @Override
    public ProductFromFile mapToRest(final Product entity) {
        return new ProductFromFile();
    }
}
