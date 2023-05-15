package com.bhx.chatgptsuggestion.configuration;

import com.bhx.chatgptsuggestion.persistence.converters.ChatGPTSuggestionRepositoryConverter;
import com.bhx.chatgptsuggestion.persistence.impl.ChatGPTSuggestionApiServiceImpl;
import com.bhx.chatgptsuggestion.persistence.impl.ChatGPTSuggestionServiceImpl;
import com.bhx.chatgptsuggestion.persistence.repository.ChatGPTSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Configuration
public class ChatGPTSuggestionConfiguration {

    @Autowired
    private ChatGPTSuggestionRepository chatGPTSuggestionRepository;


    @Bean
    public ChatGPTSuggestionRepositoryConverter chatGPTSuggestionRepositoryConverter() {
        return new ChatGPTSuggestionRepositoryConverter();
    }

    @Bean
    public ConfigVariable variable() {
        return new ConfigVariable();
    }

    @Bean
    public RestTemplate restTemplate() { return  new RestTemplate(); }
    @Bean
    public ChatGPTSuggestionApiServiceImpl chatGPTSuggestionApiService() {
        return new ChatGPTSuggestionApiServiceImpl(variable(), restTemplate());
    }

    @Bean
    public ChatGPTSuggestionServiceImpl chatGPTSuggestionService() {
        return new ChatGPTSuggestionServiceImpl(chatGPTSuggestionRepository, chatGPTSuggestionRepositoryConverter());
    }
}
