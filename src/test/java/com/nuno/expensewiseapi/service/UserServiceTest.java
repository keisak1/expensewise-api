package com.nuno.expensewiseapi.service;

import com.nuno.expensewiseapi.model.User;
import com.nuno.expensewiseapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository); //
    }

    @Test
    void createUser_success() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName("Alice");
        user.setEmail("alice@example.com");
        user.setPasswordHash(passwordEncoder.encode("1234"));

        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(userRepository.existsByName(user.getName())).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);

        User created = userService.create(user);

        assertEquals("Alice", created.getName());
        assertEquals("alice@example.com", created.getEmail());
    }

    @Test
    void createUser_duplicateEmail_throwsException() {
        User user = new User();
        user.setEmail("bob@example.com");
        user.setName("Bob");

        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            userService.create(user);
        });

        assertEquals("Email already in use", exception.getReason());
    }

    @Test
    void createUser_duplicateUsername_throwsException() {
        User user = new User();
        user.setEmail("charlie@example.com");
        user.setName("Charlie");

        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(userRepository.existsByName(user.getName())).thenReturn(true);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            userService.create(user);
        });

        assertEquals("Username already in use", exception.getReason());
    }
}
