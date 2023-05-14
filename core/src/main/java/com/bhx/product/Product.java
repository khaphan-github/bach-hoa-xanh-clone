package com.bhx.product;

import com.bhx.category.Category;
import com.bhx.shared.SelfValidating;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@NoArgsConstructor
public class Product extends SelfValidating<Product> implements Serializable {
    @Min(0)
    private String id;
    @NotEmpty()
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

    private Category category;

    private Date createdDate;
    private Date updatedDate;

    private boolean isAvailable;
}
