package com.bhx.admin.delivery.impl;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author "KhaPhan" on 11-Jun-23
 */
@Data
@Getter
@Setter
public class LoginDto {
    private String username;
    private String password;
    private boolean rememberMe;
}
