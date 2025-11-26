package com.example.jwtcors._nov.controller;

import com.example.jwtcors._nov.dto.LoginRequest;
import com.example.jwtcors._nov.dto.RegisterRequest;
import com.example.jwtcors._nov.entity.Role;
import com.example.jwtcors._nov.entity.User;
import com.example.jwtcors._nov.service.JwtUtil;
import com.example.jwtcors._nov.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.register(request.getUsername(), request.getPassword(), request.getRole());
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User u = userService.findByUsername(request.getUsername());

        if (u == null || !userService.checkPassword(request.getPassword(), u.getPassword())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        return jwtUtil.generateToken(u.getUsername(), u.getRole());
    }
}