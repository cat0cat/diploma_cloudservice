package ru.netology.cloudservice.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.cloudservice.entity.Users;
import ru.netology.cloudservice.exceptions.UnauthorizedException;
import ru.netology.cloudservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users myUser = userRepository.findByLogin(username)
                .orElseThrow(() -> new UnauthorizedException("Unauthorized error"));
        List<GrantedAuthority> authorities = new ArrayList<>();
        //authorities.add(new SimpleGrantedAuthority("READ"));
        return User.builder()
                .username(myUser.getLogin())
                .password(myUser.getPassword())
                .authorities(authorities)
                .build();
    }

}
