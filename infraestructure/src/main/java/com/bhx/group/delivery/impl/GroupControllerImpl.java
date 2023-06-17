package com.bhx.group.delivery.impl;

import com.bhx.group.delivery.converters.GroupRestConverter;
import com.bhx.group.Group;
import com.bhx.group.delivery.GroupController;
import com.bhx.group.delivery.request.CreateGroupDto;
import com.bhx.group.usecase.CreateGroupUseCase;
import com.bhx.group.usecase.GetActiveGroupsUseCase;
import com.bhx.group.usecase.GetAllGroupsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author "KhaPhan" on 10-Jun-23
 * @project clean-architecture
 */
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/groups")
public class GroupControllerImpl implements GroupController {
    private final String groupPagePrefix = "/admin/authorization/component/group/";
    private final CreateGroupUseCase createGroupUseCase;
    private final GroupRestConverter groupRestConverter;
    private final GetActiveGroupsUseCase getActiveGroupsUseCase;
    private final GetAllGroupsUseCase getAllGroupsUseCase;

    @PostMapping("/create")
    public String createGroup(@ModelAttribute("group") CreateGroupDto createGroupDto) {
        try {
            Group groupCreate = groupRestConverter.mapToEntity(createGroupDto);
            createGroupUseCase.execute(groupCreate);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return "redirect:/groups";
    }

    @GetMapping
    public String getListGroups(Model model) {
        Collection<Group> groups = this.getAllGroupsUseCase.execute();
        CreateGroupDto createGroupDto = new CreateGroupDto();
        model.addAttribute("group", createGroupDto);
        model.addAttribute("groups", groups);

        return groupPagePrefix + "group-list";
    }
}
