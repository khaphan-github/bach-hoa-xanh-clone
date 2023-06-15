package com.bhx.user.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.user.Account;
import com.bhx.user.delivery.request.CreateAccountDto;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

/**
 * @author "KhaPhan" on 29-May-23
 * @project clean-architecture
 */
public class CreateAccountConverter implements RestConverter<CreateAccountDto, Account> {
    @Override
    public Account mapToEntity(final CreateAccountDto createAccountDto) {
        Account accountConvertFromCreateAccountDto = new Account();

        accountConvertFromCreateAccountDto.setId(new ObjectId().toString());

        accountConvertFromCreateAccountDto.setUsername(createAccountDto.getUsername());
        accountConvertFromCreateAccountDto.setPassword(createAccountDto.getPassword());

        accountConvertFromCreateAccountDto.setDisplayName(createAccountDto.getFullname());
        accountConvertFromCreateAccountDto.setEmail(createAccountDto.getEmail());
        accountConvertFromCreateAccountDto.setPhone(createAccountDto.getPhone());

        accountConvertFromCreateAccountDto.setAddress("");

        accountConvertFromCreateAccountDto.setCreatedAt(new Date());
        accountConvertFromCreateAccountDto.setGroupIds(Arrays.asList(createAccountDto.getSelectedGroups()));
        accountConvertFromCreateAccountDto.setActive(createAccountDto.isActive());
        return accountConvertFromCreateAccountDto;
    }
}