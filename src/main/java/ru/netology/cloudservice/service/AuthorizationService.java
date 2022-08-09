package ru.netology.cloudservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.netology.cloudservice.model.AuthorizationRequest;
import ru.netology.cloudservice.model.AuthorizationResponse;
import ru.netology.cloudservice.repository.AuthorizationRepository;

@Slf4j
@Service
@AllArgsConstructor
public class AuthorizationService {

    AuthorizationRepository authorizationRepository;

    public AuthorizationResponse login(AuthorizationRequest authorizationRequest) {
        return null;
    }

    public ResponseEntity<?> logout(String authorizationRequest) {
        return null;
    }
}
