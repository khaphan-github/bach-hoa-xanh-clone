package com.bhx.permission;

import com.bhx.group.Group;
import com.bhx.shared.SelfValidating;
import jakarta.annotation.Nullable;
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
public class Permission extends SelfValidating<Permission> implements Serializable {
    private String id;
    /*
    * @Param action
    * Follow this format: object:method
    * Example: product:search, account:login, cart:checkout
    * */
    private String name;
    private String uri;
    private String httpMethod;
    private String effect;
    private String description;
    private Collection<Group> accessGroups;
    private List<String> accessGroupIds;
    private Date createdAt;
    private Date updatedAt;
    private boolean active;


}
