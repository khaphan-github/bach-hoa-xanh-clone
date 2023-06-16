package com.bhx.securityconfig.persistence;

import com.bhx.user.Account;
import com.bhx.user.usecase.GetAccountByUserNameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author "KhaPhan" on 10-Jun-23
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final GetAccountByUserNameUseCase getAccountByUserNameUseCase;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account account = this.getAccountByUserNameUseCase.execute(username);
            User securityUserDetail = new User(account.getUsername(), account.getPassword(), Collections.EMPTY_LIST);
            return securityUserDetail;

        } catch (AccountNotFoundException e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
