package com.bhx.securityconfig.policy.usecase;

import com.bhx.securityconfig.policy.Policy;

import java.util.Collection;

/**
 * @author "KhaPhan" on 11-Jun-23
 * @project clean-architecture
 */
public interface GetPoliciesByGroupUseCase {
    Collection<Policy> execute(String groupId);
}