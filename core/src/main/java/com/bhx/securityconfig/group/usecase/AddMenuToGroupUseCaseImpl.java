package com.bhx.securityconfig.group.usecase;

import com.bhx.menu.Menu;
import com.bhx.securityconfig.group.exceptions.MenuAlreadyExistInGroupException;
import com.bhx.securityconfig.group.ports.GroupRepositoryService;
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
