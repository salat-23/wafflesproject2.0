package com.salat23.spring.security.waffles.payload.response;

import lombok.Data;

import java.util.Set;

@Data
public class UserDetails {

    private String username;
    private String email;
    private String avatar;
    private String role;

}
