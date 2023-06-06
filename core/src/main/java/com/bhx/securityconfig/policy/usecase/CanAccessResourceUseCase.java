package com.bhx.securityconfig.policy.usecase;

import com.bhx.securityconfig.policy.exceptions.CanNotAccessResourceException;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface CanAccessResourceUseCase {
    void execute() throws CanNotAccessResourceException;
}
