package com.bhx.user.delivery.impl;

import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.usecase.GetActiveGroupsUseCase;
import com.bhx.securityconfig.user.usecase.CreateAccountUseCase;
import com.bhx.securityconfig.user.usecase.GetAccountsPagingUseCase;
import com.bhx.user.delivery.AccountController;
import com.bhx.user.delivery.converters.AccountRestConverter;
import com.bhx.user.delivery.converters.CreateAccountConverter;
import com.bhx.user.delivery.request.AddAccountToGroupDto;
import com.bhx.user.delivery.request.CreateAccountDto;
import com.bhx.user.delivery.response.AccountView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author "KhaPhan" on 28-May-23
 */

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountControllerImpl implements AccountController {
    private final AccountRestConverter accountRestConverter;
    private final CreateAccountConverter createAccountConverter;
    private final GetAccountsPagingUseCase accountsPagingUseCase;
    private final GetActiveGroupsUseCase getActiveGroupsUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final String accountPagePrefix = "/admin/authorization/component/account/";

    @GetMapping
    public String showAccounts(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 5;
        Collection<AccountView> accountPage = accountsPagingUseCase.execute(page, pageSize).stream().map(accountRestConverter::mapToRest).collect(Collectors.toList());
        Collection<Group> groups = this.getActiveGroupsUseCase.execute();

        model.addAttribute("createAccountDto", new CreateAccountDto());
        model.addAttribute("groups", groups);
        model.addAttribute("accounts", accountPage);
        model.addAttribute("currentPage", page);

        return accountPagePrefix + "account-list";
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute("createAccountDto") CreateAccountDto accountModel) {
        try {
            createAccountUseCase.execute(createAccountConverter.mapToEntity(accountModel));
        } catch (Exception ex) {

        }
        return "redirect:/accounts";
    }
    @PutMapping("/group/add")
    public ResponseEntity<AccountView> addAccountToGroup(@RequestBody AddAccountToGroupDto addAccountToGroupDto) {
        try {

        } catch (Exception e) {

        }
        return null;
    }

    @PutMapping("/group/remove")
    public ResponseEntity<AccountView> removeAccountFromGroup(@RequestBody AddAccountToGroupDto addAccountToGroupDto) {
        try {

        } catch (Exception e) {

        }
        return null;
    }

    @PostMapping("/login")
    private ResponseEntity<AccountView> login() {
        return null;
    }
}
