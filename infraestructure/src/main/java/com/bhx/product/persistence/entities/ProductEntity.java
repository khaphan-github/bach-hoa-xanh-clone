package com.bhx.product.persistence.entities;

import com.bhx.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author "KhaPhan" on 17-May-23
 * @project clean-architecture
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class ProductEntity implements Serializable {
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
