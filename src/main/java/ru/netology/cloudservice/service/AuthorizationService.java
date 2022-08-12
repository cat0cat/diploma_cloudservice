package ru.netology.cloudservice.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.netology.cloudservice.config.TokenProvider;
import ru.netology.cloudservice.model.AuthorizationRequest;
import ru.netology.cloudservice.model.AuthorizationResponse;
import ru.netology.cloudservice.repository.AuthorizationRepository;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private AuthorizationRepository authorizationRepository;
    private AuthenticationManager authenticationManager;
    private TokenProvider tokenProvider;
    private UserService userService;

    public AuthorizationResponse login(AuthorizationRequest authorizationRequest) {
        final String username = authorizationRequest.getLogin();
        final String password = authorizationRequest.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        UserDetails userDetails = userService.loadUserByUsername(username);
        String token = tokenProvider.generateToken(userDetails);
        authorizationRepository.putTokenAndUsername(token, username);
        return new AuthorizationResponse(token);
    }

    public void logout(String authToken) {
        final String token = authToken.substring(7);
        authorizationRepository.removeTokenAndUsernameByToken(token);
    }

}
