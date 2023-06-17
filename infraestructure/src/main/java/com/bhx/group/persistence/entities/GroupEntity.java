package com.bhx.group.persistence.entities;

import com.bhx.user.persistence.entities.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author "KhaPhan" on 10-Jun-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "group")
public class GroupEntity implements Serializable {
    @Id
    private String id;
    private String name;
    private String desc;
    private boolean active;
    private Date createdDate;
    private Date updatedDate;
    @DBRef
    private Collection<AccountEntity> accountEntityList;

    public GroupEntity(String id, String name, String description, boolean active, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.desc = description;
        this.active = active;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
