package com.salat23.wafflesfullstack.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "user")
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity {

    private String login;
    private String password;
    private String email;
    private String token;

}
