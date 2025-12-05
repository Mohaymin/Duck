package com.oas.sdproject;


import com.oas.sdproject.model.User;
import com.oas.sdproject.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // --- REGISTRATION ---
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // IMPORTANT: In a real app, hash the password before saving!
        userRepository.save(newUser);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }

    // --- LOGIN ---
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody User loginAttempt) {
        Optional<User> userOptional = userRepository.findByEmail(loginAttempt.getEmail());

        if (userOptional.isEmpty()) {
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
        }

        User user = userOptional.get();

        // IMPORTANT: Compare hashed passwords (using a BCrypt encoder) in a real app!
        if (user.getPassword().equals(loginAttempt.getPassword())) {
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
            // In a real app, return a JWT token or session ID here
        } else {
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
