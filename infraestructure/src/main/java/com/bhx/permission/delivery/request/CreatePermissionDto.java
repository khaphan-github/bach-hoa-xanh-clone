package com.bhx.permission.delivery.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author "KhaPhan" on 15-Jun-23
 */
@Data
public class CreatePermissionDto implements Serializable {
    private String name;
    private String uri;
    private String httpMethod;
    private String desc;
    private boolean active;
    private String type; // Permit or Deny
    private String[] selectedGroups;
}
