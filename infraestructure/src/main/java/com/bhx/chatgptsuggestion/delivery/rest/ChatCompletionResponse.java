package com.bhx.chatgptsuggestion.delivery.rest;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatCompletionResponse implements Serializable {
    private String id;
    private String object;
    private long created;
    private String model;
    private Usage usage;
    private Choice[] choices;

    public static class Usage implements Serializable {
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
    public static class Choice implements Serializable {
        private Message message;
        private String finishReason;
        private int index;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Message implements Serializable {
        private String role;
        private String content;
    }
}
