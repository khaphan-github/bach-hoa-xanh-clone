package com.bhx.user.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.group.Group;
import com.bhx.user.Account;
import com.bhx.user.delivery.request.CreateAccountDto;
import com.bhx.user.delivery.request.UpdateAccountDto;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @author "KhaPhan" on 16-Jun-23
 */
public class UpdateAccountConverter implements RestConverter<UpdateAccountDto, Account> {
    @Override
    public Account mapToEntity(final UpdateAccountDto updateAccountDto) {
        Account account = new Account();

        account.setId(updateAccountDto.getId());

        account.setUsername(updateAccountDto.getUsername());

        if (!updateAccountDto.getPassword().equals("")) {
            account.setPassword(updateAccountDto.getPassword());
        }

        account.setDisplayName(updateAccountDto.getFullname());
        account.setEmail(updateAccountDto.getEmail());
        account.setPhone(updateAccountDto.getPhone());

        account.setAddress("");
        account.setGroupIds(updateAccountDto.getSelectedGroups());
        account.setActive(updateAccountDto.isActive());

        return account;
    }

    @Override
    public UpdateAccountDto mapToRest(final Account account) {
        UpdateAccountDto updateAccountDto = new UpdateAccountDto();

        updateAccountDto.setId(account.getId());
        updateAccountDto.setUsername(account.getUsername());
        updateAccountDto.setFullname(account.getDisplayName());
        updateAccountDto.setEmail(account.getEmail());

        updateAccountDto.setPhone(account.getPhone());

        updateAccountDto.setGroups(account.getGroup());
        updateAccountDto.setSelectedGroups(account.getGroupIds());
        account.setActive(account.isActive());

        return updateAccountDto;
    }
}
