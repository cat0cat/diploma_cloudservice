package ru.netology.cloudservice.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.cloudservice.entity.User;
import ru.netology.cloudservice.exceptions.UnauthorizedException;
import ru.netology.cloudservice.repository.UserRepository;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UnauthorizedException("Unauthorized error"));
        return (UserDetails) user;
        //return (UserDetails)new User(user.getLogin(), user.getPassword(), new ArrayList<>());
    }

}
