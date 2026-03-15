package com.hotel.hotelserver.controller;

import com.hotel.hotelserver.dto.RegisterRequest;
import com.hotel.hotelserver.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository)
    {
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody RegisterRequest registerRequest)
    {
        return ResponseEntity.ok(200);
    }
}
