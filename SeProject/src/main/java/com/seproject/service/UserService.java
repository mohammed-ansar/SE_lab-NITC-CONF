package com.seproject.service;

import com.seproject.entity.User;
import com.seproject.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) {
        // Hardcoded user with username "user" and password "password"
        return org.springframework.security.core.userdetails.User.withUsername("user")
                .password("{noop}password") // {noop} indicates plain text password, as we're using hardcoded credentials
                .roles("USER")
                .build();
    }
    
    
    @Transactional
    public boolean registerNewUser(String username, String password) {
        try {
            // Check if the username is already taken
            if (userRepository.findByUsername(username).isPresent()) {
                return false; // Registration failed - username already exists
            }

            // Create a new user entity
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);

            // Save the new user to the database
            userRepository.save(newUser);

            return true; // Registration successful
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return false; // Registration failed due to an exception
        }
    }
}
