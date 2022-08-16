package ru.netology.cloudservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.cloudservice.model.AuthorizationRequest;
import ru.netology.cloudservice.service.AuthorizationService;


@RestController
@CrossOrigin
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthorizationRequest authorizationRequest) {
        service.login(authorizationRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?>logout(@RequestHeader("auth-token") String authToken) {
        service.logout(authToken);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
