package com.bhx.policy.usecase;

import com.bhx.permission.Permission;
import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.policy.Credential;

import java.util.Collection;

/**
 * @author "KhaPhan" on 15-Jun-23
 * @project clean-architecture
 */
public interface IsPublicResourceUseCase {
    boolean execute(Credential credential, String publicResourceName) throws PermissionNotFoundException;
}
