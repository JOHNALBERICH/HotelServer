package com.hotel.hotelserver.dto.Request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegisterRequest {
    private String useName;
    private String Phone;
    private String Email;
    private String Password;
}
