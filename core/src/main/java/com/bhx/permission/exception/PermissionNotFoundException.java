package com.bhx.permission.exception;

/**
 * @author "KhaPhan" on 20-May-23
 */
public class PermissionNotFoundException extends Exception {
    public PermissionNotFoundException(String id) {
        super("Permission not found for ID: " + id);
    }
}
