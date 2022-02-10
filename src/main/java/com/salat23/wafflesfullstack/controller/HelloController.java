package com.salat23.wafflesfullstack.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {


    @GetMapping("/noname")
    public Map<String, Object> helloNoName() {
        return Collections.singletonMap("data", "noname get the fuck out -\\ _ //-");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> helloAdmin() {
        return Collections.singletonMap("data", "WOW YOU ARE AN ADMIN WTF");
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public Map<String, Object> helloUser() {
        return Collections.singletonMap("data", "you are a user huh");
    }

}
