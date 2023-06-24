package com.bhx.permission.delivery.impl;

import com.bhx.group.Group;
import com.bhx.group.usecase.GetActiveGroupsUseCase;
import com.bhx.permission.Permission;
import com.bhx.permission.delivery.converters.CreatePermissionConverter;
import com.bhx.permission.delivery.converters.PermissionRestConverter;
import com.bhx.permission.delivery.converters.UpdatePermissionConverter;
import com.bhx.permission.delivery.request.CreatePermissionDto;
import com.bhx.permission.delivery.request.UpdatePermissionDto;
import com.bhx.permission.delivery.response.PermissionView;
import com.bhx.permission.delivery.PermissionController;
import com.bhx.permission.usecase.CreatePermissionUseCase;
import com.bhx.permission.usecase.GetAllPermissionUseCase;
import com.bhx.permission.usecase.GetOnePermissionUseCase;
import com.bhx.permission.usecase.UpdatePermissionUseCase;
import com.bhx.user.Account;
import com.bhx.user.delivery.request.CreateAccountDto;
import com.bhx.user.delivery.request.UpdateAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final PermissionRestConverter permissionRestConverter;
    private final CreatePermissionConverter createPermissionConverter;
    private final UpdatePermissionConverter updatePermissionConverter;

    private final GetAllPermissionUseCase getAllPermissionUseCase;
    private final GetActiveGroupsUseCase getActiveGroupsUseCase;
    private final CreatePermissionUseCase createPermissionUseCase;
    private final GetOnePermissionUseCase getOnePermissionUseCase;
    private final UpdatePermissionUseCase updatePermissionUseCase;

    private static final String PermissionPagePrefix = "/admin/authorization/component/permission/";
    private static final String RedirectToPermissionsPagePath = "redirect:/permissions";

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
    public String createPermission(@ModelAttribute("createPermissionDto") CreatePermissionDto createPermissionDto) {
        try {
            createPermissionUseCase.execute(createPermissionConverter.mapToEntity(createPermissionDto));
        } catch (Exception ex) {

        }
        return RedirectToPermissionsPagePath;
    }

    @GetMapping("/update-page")
    public String showUpdatePermissionPage(@RequestParam("id") String permissionId, Model model) {
        try {
            Permission permissionToUpdate = getOnePermissionUseCase.execute(permissionId);
            model.addAttribute("updatePermissionDto", updatePermissionConverter.mapToRest(permissionToUpdate));
        } catch (Exception ex) {
            return RedirectToPermissionsPagePath;
        }
        return PermissionPagePrefix + "update-permission-form";
    }

    @PostMapping("/update")
    public String updateAccount(@ModelAttribute("updatePermissionDto") UpdatePermissionDto updatePermissionDto) {
        try {
            updatePermissionUseCase.execute(updatePermissionConverter.mapToEntity(updatePermissionDto));
        } catch (Exception ex) {
            return String.format("redirect:/update-page?id=%s", updatePermissionDto.getId());
        }
        return RedirectToPermissionsPagePath;
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
