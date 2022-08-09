package ru.netology.cloudservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationRequest {

    private String login;
    private String password;

}
