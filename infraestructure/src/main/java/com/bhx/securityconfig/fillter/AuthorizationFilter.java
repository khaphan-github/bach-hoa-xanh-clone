package com.bhx.securityconfig.fillter;

import com.bhx.permission.exception.PermissionNotFoundException;
import com.bhx.policy.Credential;
import com.bhx.policy.exceptions.CanNotAccessResourceException;
import com.bhx.policy.usecase.CanAccessResourceUseCase;
import com.bhx.securityconfig.shared.Variable;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author "KhaPhan" on 11-Jun-23
 */
@Component
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    private CanAccessResourceUseCase canAccessResourceUseCase;

    private boolean canAccessResource(HttpServletRequest request) throws CanNotAccessResourceException, PermissionNotFoundException, AccountNotFoundException {
        Credential credential = new Credential();

        credential.setId(new ObjectId().toString());
        credential.setUri(request.getRequestURI());
        credential.setHttpMethod(request.getMethod());
        credential.setUsername((String) request.getAttribute(Variable.USERNAME_ATTRIBUTE_KEY));

        return canAccessResourceUseCase.execute(credential);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String isPublicUri = (String) request.getAttribute(Variable.PUBLIC_URI_ATTRIBUTE_KEY);

        if (isPublicUri.equals(Variable.EMPTY_ATTRIBUTE_VALUE)) {
            try {
                if (!canAccessResource(request)) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
                }
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
            }
        }

        filterChain.doFilter(request, response);
    }
}
