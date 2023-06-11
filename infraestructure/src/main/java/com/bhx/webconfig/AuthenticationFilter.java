package com.bhx.webconfig;

/**
 * @author "KhaPhan" on 10-Jun-23
 */

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    private boolean isAllowedURI(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        // TODO: Get all policy with group.name == everyone -> then get allow uri
        String[] allowedURIs = {"/admin/login", "/admin/authenticate", "/static"};

        boolean isAllowed = false;
        for (String allowedURI : allowedURIs) {
            if (requestURI.startsWith(allowedURI)) {
                isAllowed = true;
                break;
            }
        }
        return isAllowed;
    }

    private String tokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    private void validateToken(String token, HttpServletRequest request) {
        String username = jwtUtil.extractUsername(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            boolean isValidToken = Boolean.TRUE.equals(jwtUtil.validateToken(token, userDetails));

            if (isValidToken) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
    }

    private void processAuthorization(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tokenFromCookie = tokenFromCookie(request);

        if (tokenFromCookie.equals("")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Authorization is empty.");
            return;
        }
        try {
            validateToken(tokenFromCookie, request);
        } catch (ExpiredJwtException e) {
            response.sendRedirect("/admin/login");
        }
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("---> AuthenticationFilter Works");

        if (isAllowedURI(request)) {
            filterChain.doFilter(request, response);
        }

        processAuthorization(request, response);

        filterChain.doFilter(request, response);
    }

}