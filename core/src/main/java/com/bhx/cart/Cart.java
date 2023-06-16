package com.bhx.cart;

import com.bhx.shared.SelfValidating;
import com.bhx.user.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 16-Jun-23
 * @project clean-architecture
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart  extends SelfValidating<Cart> implements Serializable {
    private String id;
    private Date createdDate;
    private Date updatedDate;
    private String productId;
    private String numOfItems;
}
