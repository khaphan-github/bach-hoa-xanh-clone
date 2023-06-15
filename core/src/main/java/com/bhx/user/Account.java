package com.bhx.user;

import com.bhx.group.Group;
import com.bhx.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
    private Collection<Group> group;
    private List<String> groupIds;
    private String address;
    private Date createdAt;
    private Date lastLogin;
    private boolean isActive;
}