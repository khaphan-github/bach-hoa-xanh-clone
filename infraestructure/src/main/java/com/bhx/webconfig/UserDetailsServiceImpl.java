package com.bhx.webconfig;

import com.bhx.securityconfig.user.Account;
import com.bhx.securityconfig.user.usecase.GetAccountByUserNameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
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
            return new User(account.getUsername(), account.getPassword(), Collections.emptyList());

        } catch (AccountNotFoundException e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
