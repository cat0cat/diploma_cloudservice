package ru.netology.cloudservice;

import ru.netology.cloudservice.entity.Users;
import ru.netology.cloudservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        userRepository.save(Users.builder()
                .login("pochta1@mail.ru")
                .password(passwordEncoder.encode("pass1"))
                .build());
        userRepository.save(Users.builder()
                .login("pochta2@mail.ru")
                .password(passwordEncoder.encode("pass2"))
                .build());
        userRepository.save(Users.builder()
                .login("pochta3@mail.ru")
                .password(passwordEncoder.encode("pass3"))
                .build());
    }
}
