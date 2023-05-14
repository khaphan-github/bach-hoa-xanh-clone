package com.bhx.chatgpt;

import com.bhx.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Data
@AllArgsConstructor
public class ChatGPTSuggestion extends SelfValidating<ChatGPTSuggestion> implements Serializable {
    @NotEmpty
    private String id;
    @NotEmpty
    private String typeMessage;
    @NotEmpty
    private String formatMessage;
    @NotEmpty
    private String jsonRequire;

    private Date createdDate;
    private Date updatedDate;
}
