package com.bhx.chatgpt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTSuggestionApiResponse implements Serializable {
    private String id;
    private String object;
    private long created;
    private String model;
    private Usage usage;
    private Choice[] choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Usage {
        @JsonProperty("prompt_tokens")
        private int promptTokens;

        @JsonProperty("completion_tokens")
        private int completionTokens;

        @JsonProperty("total_tokens")
        private int totalTokens;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {
        private Message message;
        private String finishReason;
        private int index;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Message {
        private String role;
        private String content;
    }
}
