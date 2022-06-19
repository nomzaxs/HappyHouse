package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.exception.TokenRefreshException;
import com.ssafy.happyhouse.mapper.UserModifyMapper;
import com.ssafy.happyhouse.models.ERole;
import com.ssafy.happyhouse.models.RefreshToken;
import com.ssafy.happyhouse.models.Role;
import com.ssafy.happyhouse.models.User;
import com.ssafy.happyhouse.payload.request.LogOutRequest;
import com.ssafy.happyhouse.payload.request.LoginRequest;
import com.ssafy.happyhouse.payload.request.SignupRequest;
import com.ssafy.happyhouse.payload.request.TokenRefreshRequest;
import com.ssafy.happyhouse.payload.response.JwtResponse;
import com.ssafy.happyhouse.payload.response.MessageResponse;
import com.ssafy.happyhouse.payload.response.TokenRefreshResponse;
import com.ssafy.happyhouse.repository.RoleRepository;
import com.ssafy.happyhouse.repository.UserRepository;
import com.ssafy.happyhouse.security.jwt.JwtUtils;
import com.ssafy.happyhouse.security.services.RefreshTokenService;
import com.ssafy.happyhouse.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
  @Autowired
  UserModifyMapper userModify;

  @Autowired
  RefreshTokenService refreshTokenService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    String jwt = jwtUtils.generateJwtToken(userDetails);

    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
        .collect(Collectors.toList());

    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getUserid());

    return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getUserid(),
        userDetails.getUsername(), userDetails.getEmail(), roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @PostMapping("/refreshtoken")
  public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
    String requestRefreshToken = request.getRefreshToken();

    return refreshTokenService.findByToken(requestRefreshToken)
        .map(refreshTokenService::verifyExpiration)
        .map(RefreshToken::getUser)
        .map(user -> {
          String token = jwtUtils.generateTokenFromUsername(user.getUsername());
          return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
        })
        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
            "Refresh token is not in database!"));
  }
  
  @PostMapping("/logout")
  public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
    refreshTokenService.deleteByUserId(logOutRequest.getUserId());
    return ResponseEntity.ok(new MessageResponse("Log out successful!"));
  }
  
  @PutMapping("/modify")
  public ResponseEntity<?> modifyUser(@Valid @RequestBody SignupRequest signUpRequest) {
	  UserDto user = new UserDto(signUpRequest.getUsername(), signUpRequest.getEmail(),
		        encoder.encode(signUpRequest.getPassword()));
	  try {
		userModify.update(user);
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	  
	  return ResponseEntity.ok(new MessageResponse("Modify successful!"));
  }
  
  @GetMapping("/list")
  public ResponseEntity<List<UserDto>> userList(){
	  
	try {
		return new ResponseEntity<List<UserDto>>(userModify.list(), HttpStatus.OK);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
  }
  
  @DeleteMapping("/del/{email}")
  public ResponseEntity<?> deleteUser(@PathVariable String email) throws Exception {
	  System.out.println(email);
		if (userModify.deleteUser(email)) {
			return ResponseEntity.ok(new MessageResponse("Modify successful!"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Can't Delete!"));
		}
	}
}