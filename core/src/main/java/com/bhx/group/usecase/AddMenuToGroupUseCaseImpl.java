package com.bhx.group.usecase;

import com.bhx.group.exceptions.MenuAlreadyExistInGroupException;
import com.bhx.group.ports.GroupRepositoryService;
import com.bhx.menu.Menu;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author "KhaPhan" on 08-Jun-23
 */
@AllArgsConstructor
public class AddMenuToGroupUseCaseImpl implements AddMenuToGroupUseCase {
    private final GroupRepositoryService groupRepositoryService;
    @Override
    public void execute(List<Menu> menuIds, String groupId) throws MenuAlreadyExistInGroupException {
        groupRepositoryService.addMenusToGroup(groupId, menuIds);
    }
}
