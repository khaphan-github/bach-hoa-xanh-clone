package com.bhx.securityconfig.delivery.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;

/**
 * @author "KhaPhan" on 11-Jun-23
 */
@Data
@Getter
@Setter
public class LoginDto {
    private String username;
    private String password;
    @Nullable
    private boolean rememberMe;
}
