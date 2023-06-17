package com.bhx.permission.delivery.request;

import com.bhx.group.Group;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 16-Jun-23
 * @project clean-architecture
 */
@Data
public class UpdatePermissionDto implements Serializable {
    private String id;
    private String name;
    private String uri;
    private String httpMethod;
    private String desc;
    private boolean active;
    private Collection<Group> groups;
    private String type; // Permit or Deny
    private List<String> selectedGroups;
}
