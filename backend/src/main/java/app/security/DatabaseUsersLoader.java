package app.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import app.advice.UserRepository;
import app.entity.User;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initDatabase() {

        userRepository.save(new User("user", "user", "pass", passwordEncoder.encode("pass"), "USER"));
        userRepository.save(new User("admin", "admin", "adminpass", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
    }
}
