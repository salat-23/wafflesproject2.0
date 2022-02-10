package com.salat23.wafflesfullstack.dto;

import com.salat23.wafflesfullstack.entity.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {

    private String username;
    private String email;
    private Set<Role> roles = new HashSet<>();

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTO setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

}
