package com.example.Student.service;

import com.example.Student.model.User;
import com.example.Student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User validateUser(String username, String password, String role) {
        User user = userRepository.findByUsernameAndRole(username, role);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


}