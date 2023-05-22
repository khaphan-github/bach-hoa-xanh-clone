package com.bhx.permission;

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
public class Permission extends SelfValidating<Permission> implements Serializable {
    private String id;
    private String name;
    private String desc;
    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;
}
