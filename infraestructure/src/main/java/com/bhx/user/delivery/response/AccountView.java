package com.bhx.user.delivery.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author "KhaPhan" on 29-May-23
 * @project clean-architecture
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountView implements Serializable {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private List<String> groupName;
    private String permissionName;
    private Date createdAt;
    private Date lastLogin;
    private boolean isActive;
}
