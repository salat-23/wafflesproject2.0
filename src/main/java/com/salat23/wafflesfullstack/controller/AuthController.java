package com.salat23.wafflesfullstack.controller;

import com.salat23.wafflesfullstack.entity.Role;
import com.salat23.wafflesfullstack.entity.RoleEnum;
import com.salat23.wafflesfullstack.entity.User;
import com.salat23.wafflesfullstack.payload.request.LoginRequest;
import com.salat23.wafflesfullstack.payload.request.SignupRequest;
import com.salat23.wafflesfullstack.payload.response.JwtResponse;
import com.salat23.wafflesfullstack.payload.response.MessageResponse;
import com.salat23.wafflesfullstack.repository.RoleRepository;
import com.salat23.wafflesfullstack.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {





}
