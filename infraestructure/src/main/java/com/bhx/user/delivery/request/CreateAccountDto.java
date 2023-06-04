package com.bhx.user.delivery.request;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 29-May-23
 * @project clean-architecture
 */
@Data
public class CreateAccountDto implements Serializable {
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String phone;
    private String address;
    private String permissionId;
}
