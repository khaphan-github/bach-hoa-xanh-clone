package com.bhx.securityconfig.policy.ports;

import com.bhx.securityconfig.policy.Policy;

import java.util.Collection;

/**
 * @author "KhaPhan" on 11-Jun-23
 * @project clean-architecture
 */
public interface PolicyRepositoryService {
    Collection<Policy> getSystemPolicies();

    Boolean getPolicyByAccountId(String accountId);
}
