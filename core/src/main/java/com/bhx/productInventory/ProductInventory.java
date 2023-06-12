package com.bhx.productInventory;

import com.bhx.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventory  extends SelfValidating<ProductInventory> implements Serializable {
    private String storageId;
    private String productId;
    private int inventory;

}
