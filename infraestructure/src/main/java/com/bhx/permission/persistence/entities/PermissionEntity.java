package com.bhx.permission.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 22-May-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "permission")
public class PermissionEntity implements Serializable {
    @Id
    private String id;
    private String name;
    private String desc;
    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;
}
