package com.bhx.user.persistence.impl;

import com.bhx.user.ports.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author "KhaPhan" on 28-May-23
 * @project clean-architecture
 */
public class CryptoServiceImpl implements CryptoService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String encode(String text) {
        return passwordEncoder.encode(text);
    }

    @Override
    public Boolean compare(String plainText, String hashCode) {
        return passwordEncoder.matches(plainText, hashCode);
    }
}
