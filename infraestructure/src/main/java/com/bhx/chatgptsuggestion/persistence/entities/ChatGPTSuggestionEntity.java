package com.bhx.chatgptsuggestion.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ChatGPTSuggestionEntity")
public class ChatGPTSuggestionEntity implements Serializable {
    @Id
    private String id;
    private String typeMessage;
    private String formatMessage;
    private String jsonRequire;
    private Date createdDate;
    private Date updatedDate;
}
