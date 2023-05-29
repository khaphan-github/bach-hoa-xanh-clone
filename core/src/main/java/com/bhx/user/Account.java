package com.bhx.user;

import com.bhx.permission.Permission;
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
    private String password;
    private String displayName;
    private String email;
    private String phone;
    private String address;
    private String permissionId;
    private Permission permission;
    private Date createdAt;
    private Date lastLogin;
    private boolean isActive;

    public Account(String id, String username, String password, String displayName, String email, String phone, String address, String permissionId, Date createdAt, Date lastLogin, boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.permissionId = permissionId;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
    }

}
