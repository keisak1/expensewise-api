package com.nuno.expensewiseapi.dto;

public record AuthResponse(String token, Long id, String name, String email) {}
