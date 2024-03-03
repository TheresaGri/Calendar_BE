package com.app.Calendar_BE.security;

import com.app.Calendar_BE.services.UserService;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class UserSecurity implements AuthorizationManager<RequestAuthorizationContext> {

    private final UserService userService;

    public UserSecurity(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AuthorizationDecision check(Supplier authenticationSupplier, RequestAuthorizationContext ctx) {
        Long userId = Long.parseLong(ctx.getVariables().get("userId"));
        Authentication authentication = (Authentication) authenticationSupplier.get();
        System.out.println("UserSecurity check");
        return new AuthorizationDecision(hasUserId(authentication, userId));
    }


    public boolean hasUserId(Authentication authentication, Long userId) {
        return Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(principal -> {
                    if (principal instanceof Jwt) {
                        Jwt jwt = (Jwt) principal;
                        String userName = jwt.getSubject();
                        return userId.equals(userService.findIdByUsername(userName));
                    }

                    return false;
                })
                .orElse(false);
    }
}
