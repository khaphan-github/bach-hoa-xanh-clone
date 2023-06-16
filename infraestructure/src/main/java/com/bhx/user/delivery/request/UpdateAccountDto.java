package com.bhx.user.delivery.request;

import com.bhx.group.Group;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author "KhaPhan" on 16-Jun-23
 */
@Data
public class UpdateAccountDto implements Serializable {
    private String id;
    private String fullname;
    private String username;
    private String password = "";
    private String phone;
    private String email;
    private boolean active;
    private Collection<Group> groups;
    private List<String> selectedGroups;
}
