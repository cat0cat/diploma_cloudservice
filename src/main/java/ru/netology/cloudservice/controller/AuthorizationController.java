package ru.netology.cloudservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.cloudservice.model.AuthorizationRequest;
import ru.netology.cloudservice.model.AuthorizationResponse;
import ru.netology.cloudservice.service.AuthorizationService;


@RestController
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @PostMapping("/login")
    public AuthorizationResponse login(@RequestBody AuthorizationRequest authorizationRequest) {
        return service.login(authorizationRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<?>logout(@RequestHeader("auth-token") String authToken) {
        service.logout(authToken);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
