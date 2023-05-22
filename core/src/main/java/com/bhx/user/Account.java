package com.bhx.user;

import com.bhx.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 20-May-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends SelfValidating<Account> implements Serializable {
    private String id;
    private String username;
    private String email;
    private String password;
    private String permissionName;
    private Date createdAt;
    private Date lastLogin;
    private boolean isActive;
}
