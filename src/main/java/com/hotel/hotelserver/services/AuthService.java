package com.hotel.hotelserver.services;

import com.hotel.hotelserver.dto.Request.LoginRequest;
import com.hotel.hotelserver.dto.Request.RegisterRequest;
import com.hotel.hotelserver.entity.User;

public interface AuthService {

    User register(RegisterRequest request);

    User login(LoginRequest loginRequest);
}
