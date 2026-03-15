package com.hotel.hotelserver.controller;

import com.hotel.hotelserver.Implement.AuthSerImp;
import com.hotel.hotelserver.dto.Request.LoginRequest;
import com.hotel.hotelserver.dto.Request.RegisterRequest;
import com.hotel.hotelserver.entity.User;
import com.hotel.hotelserver.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User Register(@RequestBody RegisterRequest request)
    {
        System.out.println(request.getEmail());
        return authService.register(request);
    }

    @PostMapping("/login")
    public User Login(@RequestBody LoginRequest request)
    {

        return authService.login(request);
    }

}
