package com.bhx.product.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.product.Product;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
public class ProductMvcConverter implements RestConverter<ProductView, Product> {
    @Override
    public Product mapToEntity(final ProductView rest) {
        return null;
    }

    @Override
    public ProductView mapToRest(final Product entity) {
        String addToCartUrl = "/cart/product/" + entity.getId();
        String detailUrl = "/product/" + entity.getId();

        return new ProductView(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getThumbImage(), entity.getCategoryId(), addToCartUrl, detailUrl);
    }
}
