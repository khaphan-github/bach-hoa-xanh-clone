package com.bhx.securityconfig.delivery.impl;

import com.bhx.securityconfig.delivery.AuthorizationController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author "KhaPhan" on 06-Jun-23
 */

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AuthorizationControllerImpl implements AuthorizationController {
    private final String viewPrefix = "admin/authorization/";

    @GetMapping("/authorization")
    public String getAuthorizationPage(Model model) {
        // TODO: Get all permission in system
        // TODO: Get all group exist in system + status active or none;
        return viewPrefix + "authorization";
    }
}
