package com.bhx.chatgptsuggestion.configuration;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Variable {
    @Value("${chat.gpt.endpoint}")
    private String chatGPTEndpoint;

    @Value("${chat.gpt.secret-key}")
    private String chatGPTSecretKey;

    @Value("${chat.gpt.model}")
    private String chatGPTModel;
}
