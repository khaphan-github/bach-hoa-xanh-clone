package com.bhx.securityconfig.group.usecase;

import com.bhx.menu.Menu;
import com.bhx.securityconfig.group.exceptions.MenuAlreadyExistInGroupException;

import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface AddMenuToGroupUseCase {
    void execute(List<Menu> menuId, String groupId) throws MenuAlreadyExistInGroupException;
}
