package com.bhx.policy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author "KhaPhan" on 15-Jun-23
 * @project clean-architecture
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Credential {
    private String id;
    private String username;
    private String httpMethod;
    private String uri;
    private List<String> accessGroupIds;
}
