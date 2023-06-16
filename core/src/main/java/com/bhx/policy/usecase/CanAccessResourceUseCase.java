package com.bhx.policy.usecase;

import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.policy.Credential;
import com.bhx.policy.exceptions.CanNotAccessResourceException;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface CanAccessResourceUseCase {
    boolean execute(Credential credential) throws CanNotAccessResourceException, AccountNotFoundException, PermissionNotFoundException;
}
