package com.salat23.spring.security.waffles.payload.request;

import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {

    private String username;

    private String email;

    private String password;

}
