package com.gainstar.api.controller;

import com.gainstar.api.entity.user.User;
import com.gainstar.api.entity.user.UserCreationDTO;
import com.gainstar.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
            User foundUser = this.userService.getUser(id);
            if (foundUser == null) {
                return ResponseEntity.status(404).build();
            }
            return ResponseEntity.status(200).body(foundUser);
        }
        catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


    @PutMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserCreationDTO user) {
        try {
            User newUser = this.userService.createUser(user);
            if (newUser == null) {
                return ResponseEntity.status(400).build();
            }
            return ResponseEntity.status(201).body(newUser);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
