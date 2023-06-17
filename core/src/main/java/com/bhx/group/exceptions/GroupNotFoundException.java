package com.bhx.group.exceptions;

/**
 * @author "KhaPhan" on 14-Jun-23
 * @project clean-architecture
 */
public class GroupNotFoundException extends Exception {
    public GroupNotFoundException(String message) {
        super(message);
    }
}
