package com.nuno.expensewiseapi.controller;

import com.nuno.expensewiseapi.dto.UserDTO;
import com.nuno.expensewiseapi.mapper.UserMapper;
import com.nuno.expensewiseapi.model.User;
import com.nuno.expensewiseapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/username")
    public User getByUsername(@RequestParam String username) {
        User user = userService.getByName(username);
        if(user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        return user;
    }

    @GetMapping("/email")
    public User getByEmail(@RequestParam String email) {
        Optional<User> user = userService.getByEmail(email);
        if(user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        return user.get();
    }
    @PostMapping
    public User create(User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        return UserMapper.mapToDTO(user);
    }


    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        User user = userService.getById(id);
        userService.delete(user);
    }

}
