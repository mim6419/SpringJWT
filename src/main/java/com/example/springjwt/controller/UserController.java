package com.example.springjwt.controller;

import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<?> getUserInfo(Authentication authentication){
        String name = authentication.getName();
        UserEntity findUser = userRepository.findByUsername(name);
        if(findUser == null){
            ResponseEntity.badRequest().body("no user");
        }
        return ResponseEntity.ok(name);
    }
}
