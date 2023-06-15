package com.bhx.group.usecase;

import com.bhx.group.exceptions.MenuAlreadyExistInGroupException;
import com.bhx.menu.Menu;

import java.util.List;

/**
 * @author "KhaPhan" on 06-Jun-23
 * @project clean-architecture
 */
public interface AddMenuToGroupUseCase {
    void execute(List<Menu> menuId, String groupId) throws MenuAlreadyExistInGroupException;
}
