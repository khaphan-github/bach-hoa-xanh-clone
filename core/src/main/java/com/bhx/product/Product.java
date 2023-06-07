package com.bhx.product;

import com.bhx.shared.SelfValidating;
import lombok.*;

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
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    private String searchName;

    private String description;

    private String thumbImage;

    private List<String> descriptionImages;

    private Date outDate;
    @Min(0)
    private double price;
    @Min(0)
    private double discount;
    @Min(0)
    private int quantity;

    private String categoryId;

    private Date createdDate;
    private Date updatedDate;

    private boolean isAvailable;
    private String storageId;
    @Min(0)
    private int inventory;
}
