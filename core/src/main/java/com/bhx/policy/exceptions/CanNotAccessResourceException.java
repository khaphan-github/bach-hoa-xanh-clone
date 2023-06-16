package com.bhx.policy.exceptions;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public class CanNotAccessResourceException extends Exception {
    public CanNotAccessResourceException(String message) {
        super(message);
    }
}
