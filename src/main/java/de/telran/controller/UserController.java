package de.telran.controller;

import de.telran.jwt.JwtAuthentication;
import de.telran.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for handling API requests.
 * <p>
 * This controller provides endpoints for different user roles to access
 * specific resources. It leverages the AuthService to obtain authentication information.
 * </p>
 *
 * @RestController      - Indicates that this class is a controller where
 *                        every method returns a domain object instead of a view.
 * @RequestMapping      - Maps HTTP requests to handler functions of MVC and REST controllers.
 * @RequiredArgsConstructor - Lombok annotation, generates a constructor for all final fields,
 *                           with parameter order same as field order.
 *
 * @author A-R
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    /**
     * The authentication service bean for handling authentication operations.
     */
    private final AuthService authService;

    /**
     * Endpoint for users with 'USER' authority to access.
     * <p>
     * This method returns a greeting message to the user.
     * </p>
     *
     * @return a ResponseEntity containing the greeting message.
     */
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    /**
     * Endpoint for users with 'ADMIN' authority to access.
     * <p>
     * This method returns a greeting message to the admin.
     * </p>
     *
     * @return a ResponseEntity containing the greeting message.
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }

}


