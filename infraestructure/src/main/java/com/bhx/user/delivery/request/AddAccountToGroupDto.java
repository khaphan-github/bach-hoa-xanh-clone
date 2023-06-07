package com.bhx.user.delivery.request;

import lombok.Data;

import java.util.List;

/**
 * @author "KhaPhan" on 07-Jun-23
 */
@Data
public class AddAccountToGroupDto {
    private String accountId;
    private List<String> groupIds;
}
