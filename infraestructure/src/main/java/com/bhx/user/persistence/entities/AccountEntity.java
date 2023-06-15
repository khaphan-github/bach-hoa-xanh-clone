package com.bhx.user.persistence.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
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
    private Date createdAt;
    private Date lastLogin;
    private boolean active;
    private List<String> groupIds;
}
