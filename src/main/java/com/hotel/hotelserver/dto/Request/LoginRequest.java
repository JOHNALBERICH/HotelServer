package com.hotel.hotelserver.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String Email;
    private String Password;
}
