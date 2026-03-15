package com.hotel.hotelserver.services;

import com.hotel.hotelserver.dto.Request.LoginRequest;
import com.hotel.hotelserver.dto.Request.RegisterRequest;
import com.hotel.hotelserver.dto.Request.UpdateProfileRequest;
import com.hotel.hotelserver.dto.Response.UserResponse;

public interface UserService {
    UserResponse Register(RegisterRequest registerRequest);
    String Login (LoginRequest request);
    UserResponse getProfile(Long userId);
    UserResponse updateProfile(Long userId, UpdateProfileRequest updateProfileRequest);
}
