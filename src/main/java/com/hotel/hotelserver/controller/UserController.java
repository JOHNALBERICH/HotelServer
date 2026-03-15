package com.hotel.hotelserver.controller;

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

    @GetMapping("/Hello")
    public ResponseEntity<?>TestApi()
    {
        return ResponseEntity.ok("This is testapi");
    }

}
