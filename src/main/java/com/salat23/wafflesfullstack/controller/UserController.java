package com.salat23.wafflesfullstack.controller;


import com.salat23.wafflesfullstack.dto.UserDTO;
import com.salat23.wafflesfullstack.entity.User;
import com.salat23.wafflesfullstack.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/me")

    public UserDTO me() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s was not found", username)));

        return new UserDTO()
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setRoles(user.getRoles());
    }

}