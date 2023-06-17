package com.bhx.product.delivery.converters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
@Getter
@Setter
public class ProductView implements Serializable {
    private String id;
    private String name;
    private String desc;
    private double price;
    private String thumbImage;
    private String categoryName;
    private String addToCartUrl;
    private String detailUrl;

    private int inventory;
    private String imageLink;
}
