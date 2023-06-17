package com.bhx.product;

import com.bhx.shared.SelfValidating;
import lombok.*;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends SelfValidating<Product> implements Serializable {
    @Nullable
    private String id;
    @NotEmpty
    private String name;
    private String searchName;


    @Nullable
    private String description;
    @Nullable
    private String thumbImage;

    private List<String> descriptionImages;

    private Date outDate;
    @Min(0)
    private double price;
    @Min(0)
    @Nullable
    private double discount;
    @Min(0)
    private int quantity;

    private String categoryId;

    private Date createdDate;
    private Date updatedDate;

    @Nullable
    private boolean isAvailable;

    public Product(String name, @Nullable String description, List<String> descriptionImages, Date outDate, double price,@Nullable double discount, int quantity, String categoryId) {
        this.name = name;
        this.description = description;
        this.descriptionImages = descriptionImages;
        this.outDate = outDate;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.isAvailable = true;
    }

    private int inventory;
    @Nullable

    private String imageLink;
}
