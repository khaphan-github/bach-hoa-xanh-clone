package com.bhx.user.persistence.entities;

import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.persistence.entities.GroupEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author "KhaPhan" on 28-May-23
 * @project clean-architecture
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class AccountEntity implements Serializable {
    @Id
    private String id;
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String phone;
    private String address;
    @DBRef
    private Collection<GroupEntity> groups;
    private Date createdAt;
    private Date lastLogin;
    private boolean active;


    public AccountEntity(String id, String username, String password, String displayName, String email, String phone, String address, Date createdAt, Date lastLogin, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.active = active;
    }
}
