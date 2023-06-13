package com.bhx.securityconfig.group.delivery.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author "KhaPhan" on 10-Jun-23
 */
@Data
public class CreateGroupDto implements Serializable {
    private String name;
    private String description;
    private boolean active;
}
