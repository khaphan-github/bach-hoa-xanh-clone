package com.bhx.user.configuration;

import com.bhx.user.persistence.impl.CryptoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author "KhaPhan" on 28-May-23
 * @project clean-architecture
 */
@Configuration
public class BcryptPasswordEncoderConfiguration {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CryptoServiceImpl cryptoService() {
        return new CryptoServiceImpl();
    }

}
