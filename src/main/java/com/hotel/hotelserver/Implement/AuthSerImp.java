package com.hotel.hotelserver.Implement;

import com.hotel.hotelserver.entity.Role;
import com.hotel.hotelserver.entity.User;
import com.hotel.hotelserver.dto.Request.LoginRequest;
import com.hotel.hotelserver.dto.Request.RegisterRequest;
import com.hotel.hotelserver.repository.UserRepository;
import com.hotel.hotelserver.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthSerImp implements AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUseName());
        user.setPhone(registerRequest.getPhone());
        user.setEmail(registerRequest.getEmail());

        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.USER);
        user.setActive(true);
        return user;

    }

    @Override
    public User login(LoginRequest loginRequest) {
        User user = repository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new RuntimeException("User not found"));
        boolean isMatch = passwordEncoder.matches(loginRequest.getPassword(),user.getPassword());
        if(!isMatch)
        {
            throw new RuntimeException("Invalid Password");
        }
        return user;
    }
}
