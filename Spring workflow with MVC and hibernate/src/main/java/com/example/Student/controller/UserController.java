package com.example.Student.controller;

import com.example.Student.model.User;
import com.example.Student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

@CrossOrigin(origins = {"http://localhost:5502", "http://127.0.0.1:5502"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role) {

        User user = userService.validateUser(username, password, role);
        if (user != null) {
            return ResponseEntity.ok().body(Map.of(
                    "message", "Login success",
                    "username", user.getUsername(),
                    "role", user.getRole()
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
    }
}
