package com.bhx.webconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author "KhaPhan" on 11-Jun-23
 * @project clean-architecture
 */
@Component
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        // TOTO: HANDLE AUTHORIZATION:
        log.info("---> AuthorizationFilter Works");
        filterChain.doFilter(request, response);
    }
}
