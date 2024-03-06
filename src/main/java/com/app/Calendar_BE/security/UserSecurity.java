package com.app.Calendar_BE.security;

import com.app.Calendar_BE.models.User;
import com.app.Calendar_BE.repositories.UserRepository;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class UserSecurity implements AuthorizationManager<RequestAuthorizationContext> {

    private final UserRepository userRepository;

    public UserSecurity(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        String username = object.getVariables().get("username");
        Authentication authenticationSupplier = (Authentication) authentication.get();
        return new AuthorizationDecision(hasUsername(authenticationSupplier, username));
    }

    public boolean hasUsername(Authentication authentication, String username) {
// Check if authentication is not null
        if (authentication != null) {
            // Retrieve the principal from the authentication
            Object principal = authentication.getPrincipal();

            // Check if the principal is an instance of Jwt
            if (principal instanceof Jwt) {
                Jwt jwt = (Jwt) principal;

                // Extract the username from the Jwt
                String userName = jwt.getSubject();

                User user = userRepository.findByUsername(userName).orElse(null);
                String userNameOfUser = "";
                if (user != null) {
                    userNameOfUser = user.getUsername();
                }
                // Check if userIdFromService is not null and matches the provided userId
                return userNameOfUser != "" && userNameOfUser.equals(username);
            }
        }

        // Default to false if any condition is not met
        return false;
    }
}
