package com.bhx.group.usecase;

import com.bhx.group.Group;

import java.util.Collection;

/**
 * @author "KhaPhan" on 13-Jun-23
 * @project clean-architecture
 */
public interface GetActiveGroupsUseCase {
    Collection<Group> execute() ;
}
