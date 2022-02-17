package com.salat23.waffles.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.salat23.waffles.models.*;
import com.salat23.waffles.repository.ExpandedUserRepository;
import com.salat23.waffles.repository.ImageResourceRepository;
import com.salat23.waffles.payload.request.LoginRequest;
import com.salat23.waffles.payload.request.SignupRequest;
import com.salat23.waffles.payload.response.MessageResponse;
import com.salat23.waffles.repository.RoleRepository;
import com.salat23.waffles.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salat23.waffles.payload.response.JwtResponse;
import com.salat23.waffles.security.jwt.JwtUtils;
import com.salat23.waffles.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final ExpandedUserRepository expandedUserRepository;
	private final RoleRepository roleRepository;
	private final ImageResourceRepository imageResourceRepository;
	private final PasswordEncoder encoder;
	private final JwtUtils jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, ExpandedUserRepository expandedUserRepository, RoleRepository roleRepository, ImageResourceRepository imageResourceRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.expandedUserRepository = expandedUserRepository;
		this.roleRepository = roleRepository;
		this.imageResourceRepository = imageResourceRepository;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
	}


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);

		ExpandedUser expandedUser = new ExpandedUser();
		expandedUser.setUser(user);
		ImageResource defaultAvatar = imageResourceRepository.findImageResourceById(1L);
		expandedUser.setAvatar(defaultAvatar);

		user.setRoles(roles);
		userRepository.save(user);
		expandedUserRepository.save(expandedUser);

		return ResponseEntity.ok(user);
	}
}
