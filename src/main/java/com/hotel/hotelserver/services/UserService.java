package com.hotel.hotelserver.services;

import com.hotel.hotelserver.dto.LoginRequest;
import com.hotel.hotelserver.dto.RegisterRequest;
import com.hotel.hotelserver.dto.UpdateProfileRequest;
import com.hotel.hotelserver.dto.UserResponse;

public interface UserService {
    UserResponse Register(RegisterRequest registerRequest);
    String Login (LoginRequest request);
    UserResponse getProfile(Long userId);
    UserResponse updateProfile(Long userId, UpdateProfileRequest updateProfileRequest);
}
