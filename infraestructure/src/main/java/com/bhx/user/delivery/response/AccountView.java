package com.bhx.user.delivery.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author "KhaPhan" on 29-May-23
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountView implements Serializable {
    private String id;
    private String username;
    private String displayName;
    private String email;
    private String phone;
    private String address;
    private Collection<String> groupNames;
    private Date createdAt;
    private Date lastLogin;
    private boolean active;
}
