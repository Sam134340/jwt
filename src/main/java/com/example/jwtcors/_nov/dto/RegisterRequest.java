package com.example.jwtcors._nov.dto;

import com.example.jwtcors._nov.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
