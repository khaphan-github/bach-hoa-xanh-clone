package com.bhx.permission.delivery.impl;

import com.bhx.group.Group;
import com.bhx.group.usecase.GetActiveGroupsUseCase;
import com.bhx.permission.delivery.converters.CreatePermissionConverter;
import com.bhx.permission.delivery.converters.PermissionRestConverter;
import com.bhx.permission.delivery.request.CreatePermissionDto;
import com.bhx.permission.delivery.response.PermissionView;
import com.bhx.permission.delivery.PermissionController;
import com.bhx.permission.usecase.CreatePermissionUseCase;
import com.bhx.permission.usecase.GetAllPermissionUseCase;
import com.bhx.user.delivery.request.CreateAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author "KhaPhan" on 22-May-23
 */

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/permissions")
public class PermissionControllerImpl implements PermissionController {
    private final String PermissionPagePrefix = "/admin/authorization/component/permission/";
    private final PermissionRestConverter permissionRestConverter;
    private final CreatePermissionConverter createPermissionConverter;
    private final GetAllPermissionUseCase getAllPermissionUseCase;
    private final GetActiveGroupsUseCase getActiveGroupsUseCase;
    private final CreatePermissionUseCase createPermissionUseCase;
    @Override
    @GetMapping
    public String getAllPermission(Model model) {
        Collection<PermissionView> permissionViews = getAllPermissionUseCase.execute().stream().map(permissionRestConverter::mapToRest).collect(Collectors.toList());
        Collection<Group> groups = this.getActiveGroupsUseCase.execute();

        model.addAttribute("permissions", permissionViews);
        model.addAttribute("createPermissionDto", new CreatePermissionDto());

        model.addAttribute("groups", groups);
        return PermissionPagePrefix + "authorization";
    }

    @Override
    @PostMapping("/create")
    public String createPermission(@ModelAttribute("createAccountDto") CreatePermissionDto createPermissionDto) {
        try {
            createPermissionUseCase.execute(createPermissionConverter.mapToEntity(createPermissionDto));
        } catch (Exception ex) {

        }
        return "redirect:/permissions";
    }
    @Override
    public String getOnePermission(String id) {
        return null;
    }

    @Override
    public String invalidPermission(String id) {
        return null;
    }

    @Override
    public String updatePermission(PermissionView permissionView) {
        return null;
    }
}
