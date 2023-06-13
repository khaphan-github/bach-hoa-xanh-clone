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
@RequestMapping("/authorization")
public class AuthorizationControllerImpl implements AuthorizationController {
    private final String viewPrefix = "admin/authorization/";

    @GetMapping
    public String getAuthorizationPage(Model model) {
        return viewPrefix + "authorization";
    }
}
