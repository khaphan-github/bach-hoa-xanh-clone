package com.bhx.user.delivery.impl;

import com.bhx.group.Group;
import com.bhx.group.usecase.GetActiveGroupsUseCase;
import com.bhx.user.Account;
import com.bhx.user.delivery.converters.UpdateAccountConverter;
import com.bhx.user.delivery.request.UpdateAccountDto;
import com.bhx.user.usecase.*;
import com.bhx.user.delivery.AccountController;
import com.bhx.user.delivery.converters.AccountRestConverter;
import com.bhx.user.delivery.converters.CreateAccountConverter;
import com.bhx.user.delivery.request.AddAccountToGroupDto;
import com.bhx.user.delivery.request.CreateAccountDto;
import com.bhx.user.delivery.response.AccountView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
    private final UpdateAccountConverter updateAccountConverter;
    private final GetAccountsPagingUseCase accountsPagingUseCase;
    private final GetOneAccountUseCase getOneAccountUseCase;
    private final GetActiveGroupsUseCase getActiveGroupsUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    private final CreateAccountWithGroupUseCase accountWithGroupUseCase;
    private final String accountPagePrefix = "/admin/authorization/component/account/";
    private final String redirectAccountsPage = "redirect:/accounts";

    @GetMapping
    public String showAccounts(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 100;

        Collection<AccountView> accountPage = accountsPagingUseCase.execute(page, pageSize)
                .stream().map(accountRestConverter::mapToRest)
                .collect(Collectors.toList());

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
        return redirectAccountsPage;
    }

    @GetMapping("/update-page")
    public String showUpdateAccountPage(@RequestParam("id") String accountId, Model model) {
        try {
            Account account = getOneAccountUseCase.execute(accountId);
            model.addAttribute("updateAccountDto", updateAccountConverter.mapToRest(account));
        } catch (Exception ex) {
            return redirectAccountsPage;
        }
        return accountPagePrefix + "update-account-form";
    }

    @PostMapping("/update")
    public String updateAccount(@ModelAttribute("updateAccountDto") UpdateAccountDto updateAccountDto) {
        try {
            updateAccountUseCase.execute(updateAccountConverter.mapToEntity(updateAccountDto));
        } catch (Exception ex) {
            return String.format("redirect:/update-page?id=%s", updateAccountDto.getId());
        }
        return redirectAccountsPage;
    }
}
