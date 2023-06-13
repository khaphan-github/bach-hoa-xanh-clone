package com.bhx.securityconfig.group.usecase;

import com.bhx.securityconfig.group.Group;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-Jun-23
 * @project clean-architecture
 */
public interface GetActiveGroupsUseCase {
    Collection<Group> execute() ;
}
