package com.bhx.securityconfig.fillter;

/**
 * @author "KhaPhan" on 10-Jun-23
 */

import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.policy.Credential;
import com.bhx.policy.usecase.IsPublicResourceUseCase;
import com.bhx.securityconfig.JwtUtil;
import com.bhx.securityconfig.persistence.UserDetailsServiceImpl;
import com.bhx.securityconfig.shared.Variable;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
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
    private IsPublicResourceUseCase isPublicResourceUseCase;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    private boolean isAllowedURI(HttpServletRequest request) throws PermissionNotFoundException {
        Credential credential = new Credential();

        credential.setUri(request.getRequestURI());
        credential.setHttpMethod(request.getMethod());
        credential.setId(new ObjectId().toString());

        return isPublicResourceUseCase.execute(credential, Variable.PUBLIC_RESOURCES_GROUP_NAME);
    }

    private String tokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Variable.TOKEN_COOKIE_KEY)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    private String validateToken(String token, HttpServletRequest request) {
        String username = jwtUtil.extractUsername(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            boolean isValidToken = Boolean.TRUE.equals(jwtUtil.validateToken(token, userDetails));

            if (isValidToken) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        return username;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        request.setAttribute(Variable.PUBLIC_URI_ATTRIBUTE_KEY, Variable.EMPTY_ATTRIBUTE_VALUE);

        try {
            if (isAllowedURI(request)) {
                request.setAttribute(Variable.PUBLIC_URI_ATTRIBUTE_KEY, Variable.PUBLIC_URI_ATTRIBUTE_KEY);
                filterChain.doFilter(request, response);
                return;
            }
        } catch (PermissionNotFoundException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            return;
        }

        String tokenFromCookie = tokenFromCookie(request);

        if (tokenFromCookie.equals("")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Authorization is empty.");
            return;
        }

        try {
            String username = validateToken(tokenFromCookie, request);
            request.setAttribute(Variable.USERNAME_ATTRIBUTE_KEY, username);
        } catch (ExpiredJwtException e) {
            response.sendRedirect(Variable.AUTHENTICATION_PAGE_PATH);
        }

        filterChain.doFilter(request, response);

    }

}