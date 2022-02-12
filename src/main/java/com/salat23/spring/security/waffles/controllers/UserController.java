package com.salat23.spring.security.waffles.controllers;

import com.salat23.spring.security.waffles.models.ExpandedUser;
import com.salat23.spring.security.waffles.models.User;
import com.salat23.spring.security.waffles.payload.response.UserDetails;
import com.salat23.spring.security.waffles.repository.ExpandedUserRepository;
import com.salat23.spring.security.waffles.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final ExpandedUserRepository expandedUserRepository;


    public UserController(UserRepository userRepository, ExpandedUserRepository expandedUserRepository) {
        this.userRepository = userRepository;
        this.expandedUserRepository = expandedUserRepository;
    }

    @GetMapping("/me")
    public UserDetails username() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User %s was not found", username)));
        ExpandedUser expandedUser = expandedUserRepository.findExpandedUserByUser(user);


        UserDetails response = new UserDetails();
        response.setAvatar(expandedUser.getAvatar().getUrl());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        String highestRole = user.getRoles().stream().max(Comparator.comparingInt(r -> r.getName().getPriority())).get().getName().name();
        response.setRole(highestRole);

        return response;
    }

}
