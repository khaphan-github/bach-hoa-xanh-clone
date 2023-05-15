package com.bhx.chatgpt;

import com.bhx.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
/**
 * Represents a suggestion for a chat message in a chatbot system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTSuggestion extends SelfValidating<ChatGPTSuggestion> implements Serializable {

    /**
     * The unique identifier for the chat suggestion.
     */
    @NotEmpty
    private String id;

    /**
     * The type of the chat message.
     */
    @NotEmpty
    private String typeMessage;

    /**
     * The format of the chat message.
     * Example:
     *  { formatMessage: "Top 5 món ăn từ message_replace theo định dạnh:" }
     */
    @NotEmpty
    private String formatMessage;

    /**
     * The JSON representation of the required chat data after chat-bot answer your request
     * Example:
     * {"dishes": [{"dishName": "Tên món ăn","description": "Mô tả ngắn"}], "relatedProducts": [{"name": "Tên sản phẩm liên quan"}]}
     */
    @NotEmpty
    private String jsonRequire;

    /**
     * The date when the chat suggestion was created.
     */
    private Date createdDate;

    /**
     * The date when the chat suggestion was last updated.
     */
    private Date updatedDate;
}
