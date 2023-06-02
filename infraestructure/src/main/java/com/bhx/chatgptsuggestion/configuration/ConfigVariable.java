package com.bhx.chatgptsuggestion.configuration;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Component
@Getter
@Setter
public class ConfigVariable {
    @Value("${chat.gpt.endpoint}")
    private String endpoint;
    String secretKey;
    String model;
    Boolean enable;
}
