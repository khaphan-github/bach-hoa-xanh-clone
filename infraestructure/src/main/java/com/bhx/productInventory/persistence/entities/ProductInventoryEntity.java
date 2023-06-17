package com.bhx.productInventory.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productInventory")
public class ProductInventoryEntity implements Serializable {
    private String productId;
    private String storageId;
    private int inventory;
}
