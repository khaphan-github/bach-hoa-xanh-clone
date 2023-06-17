package com.bhx.permission.delivery.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author "KhaPhan" on 22-May-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionView implements Serializable {
    private String id;
    private String name;
    private String uri;
    private String method;
    private List<String> groupNames;
    private boolean active;
    private String description;
}
