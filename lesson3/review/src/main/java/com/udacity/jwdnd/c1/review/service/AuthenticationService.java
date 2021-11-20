package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
// note: override AuthenticationProvider中的 authenticate and supports method
public class AuthenticationService implements AuthenticationProvider {
    private UserMapper userMapper;
    private HashService hashService;

    public AuthenticationService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    @Override
    //used by Spring Security to check credentials it receives from its special login form
    //our implementation tell spring how to check

    // check the Authentication object is valid and return another authentication object if
    // the user is authenticated successfully
    // Spring security can integrate with many different authentication schemes, but we are going
    // to use username and password authentication
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userMapper.getUser(username);
        if (user != null) {
            String encodedSalt = user.getSalt();
            // salt + password ===== hash password
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (user.getPassword().equals(hashedPassword)) {
                // represent a successful authentication of a specific username and password
                // list of granted authorities
                // the list of specific permissions the user was granted
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }

        return null;
    }

    @Override
    // note: tell Spring which authentication schemes this class can handle
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
