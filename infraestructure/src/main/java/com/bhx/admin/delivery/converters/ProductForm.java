package com.bhx.admin.delivery.converters;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductForm {
    private String name;
    private int price;
    @Nullable
    private String description;
    @Nullable
    private Date outDate;
    @Nullable
    private int discount;
    private int quantity;
    private String productCategoryId;
    private String descriptionImages;
}
