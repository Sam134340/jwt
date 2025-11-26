package com.example.jwtcors._nov.service;

import com.example.jwtcors._nov.entity.Role;
import com.example.jwtcors._nov.entity.User;
import com.example.jwtcors._nov.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User register(String username, String password, Role role){
        User u = new User();
        u.setUsername(username);
        u.setPassword(encoder.encode(password));
        u.setRole(role);

        return userRepository.save(u);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(String raw, String encoded){
        return encoder.matches(raw, encoded);
    }
}
