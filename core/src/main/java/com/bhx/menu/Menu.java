package com.bhx.menu;

import com.bhx.shared.SelfValidating;
import com.bhx.securityconfig.user.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 04-Jun-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends SelfValidating<Account> implements Serializable {
    private String id;
    private String displayName;
    private String link;
    private Boolean isActive;
    private String icon;
    private String parentId;
    private Boolean isRoot;
    private Boolean isHaveChild;
    private String userCreate;
    private Date createdDate;
    private Date updatedDate;
    private String description;
}
