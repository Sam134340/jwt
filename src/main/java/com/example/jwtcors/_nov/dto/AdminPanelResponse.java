package com.example.jwtcors._nov.dto;

public record AdminPanelResponse(String title, Long userId, String username, String role, Object permissions) {
}
