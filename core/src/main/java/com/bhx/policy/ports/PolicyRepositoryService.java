package com.bhx.policy.ports;

import com.bhx.policy.Credential;
import com.bhx.policy.Policy;

import java.util.Collection;

/**
 * @author "KhaPhan" on 11-Jun-23
 * @project clean-architecture
 */
public interface PolicyRepositoryService {
    Collection<Policy> getSystemPolicies();

    Boolean getPolicyByAccountId(String accountId);

    Collection<Policy> getPolicyByCredential(Credential credential);
}
