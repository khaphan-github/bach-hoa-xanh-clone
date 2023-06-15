package com.bhx.permission.persistence.entities;

import com.bhx.group.persistence.entities.GroupEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private String uri;
    private String resource;
    private String desc;
    private Date createdAt;
    private Date updatedAt;
    private boolean active;
    @DBRef
    private List<GroupEntity> groupEntityList;
}
