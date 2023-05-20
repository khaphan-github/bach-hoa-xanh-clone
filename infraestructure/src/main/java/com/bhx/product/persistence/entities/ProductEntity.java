package com.bhx.product.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    @Id
    private String id;
    private String name;
    private String searchName;
    private String description;
    private String thumbImage;
    private List<String> descriptionImages;
    private Date outDate;
    private double price;
    private double discount;
    private int quantity;
    private String categoryId;
    private Date createdDate;
    private Date updatedDate;
    private boolean isAvailable;
}
