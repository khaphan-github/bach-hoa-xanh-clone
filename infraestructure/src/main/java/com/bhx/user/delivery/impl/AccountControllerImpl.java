package com.bhx.user.delivery.impl;

import com.bhx.securityconfig.user.usecase.GetAccountsPagingUseCase;
import com.bhx.user.delivery.AccountController;
import com.bhx.user.delivery.converters.AccountRestConverter;
import com.bhx.user.delivery.request.AddAccountToGroupDto;
import com.bhx.user.delivery.response.AccountView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author "KhaPhan" on 28-May-23
 */

@RestController("/account")
@Slf4j
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {
    private final AccountRestConverter accountRestConverter;
    private final GetAccountsPagingUseCase accountsPagingUseCase;

    @GetMapping
    public ResponseEntity<List<AccountView>> getAccounts(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        try {
            List<AccountView> accountViews = accountsPagingUseCase.execute(page, size)
                    .stream().map(accountRestConverter::mapToRest).collect(Collectors.toList());
            return ResponseEntity.ok(accountViews);
        } catch (Exception e) {
        }
        return null;
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
