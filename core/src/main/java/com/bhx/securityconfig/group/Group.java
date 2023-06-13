package com.bhx.securityconfig.group;

import com.bhx.menu.Menu;
import com.bhx.securityconfig.permission.Permission;
import com.bhx.securityconfig.user.Account;
import com.bhx.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group extends SelfValidating<Group> implements Serializable {
    private String id;
    private String name;
    private String description;
    private boolean active;
}
