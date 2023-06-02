package com.bhx.user.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.user.Account;
import com.bhx.user.delivery.request.CreateAccountDto;
import org.bson.types.ObjectId;

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

        accountConvertFromCreateAccountDto.setDisplayName(createAccountDto.getDisplayName());
        accountConvertFromCreateAccountDto.setEmail(createAccountDto.getEmail());
        accountConvertFromCreateAccountDto.setPhone(createAccountDto.getPhone());

        accountConvertFromCreateAccountDto.setAddress(createAccountDto.getAddress());

        accountConvertFromCreateAccountDto.setCreatedAt(new Date());

        accountConvertFromCreateAccountDto.setPermissionId(createAccountDto.getPermissionId());

        return accountConvertFromCreateAccountDto;
    }
}