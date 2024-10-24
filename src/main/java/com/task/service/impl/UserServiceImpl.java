package com.task.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.dto.LoginRequest;
import com.task.dto.Response;
import com.task.dto.UserDTO;
import com.task.entity.User;
import com.task.exception.OurException;
import com.task.repository.UserRepository;
import com.task.service.interfac.UserService;
import com.task.utils.JWTUtils;
import com.task.utils.Utils;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public Response register(User user) {
		Response response = new Response();
		try {
			
			if(user.getRole()==null || user.getRole().isBlank()) {
				user.setRole("USER");
			}
			
			if(user.getSubscription()==null || user.getSubscription().isBlank()) {
				user.setSubscription("Basic");
			}
			
			if(!user.isIsaccept()) {
				throw new OurException("Please accept Terms of Services");
			}
			
			if(user.getFirstname()==null || user.getEmail()==null || user.getDateofbirth()==null || user.getPassword()==null || user.getLastname()==null) {
				throw new OurException("Please Fill all the fields");
			}
			if(userRepository.existsByEmail(user.getEmail())) {
				throw new OurException("User Already exist");
			}
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User savedUser = userRepository.save(user);
			
			UserDTO userDTO = Utils.mapUserEntityToUserDTO(savedUser);
			emailService.sendEmailOnRegister(user.getFirstname(), user.getLastname(), user.getEmail());
			response.setStatusCode(200);
			response.setMessage("success");
			response.setUser(userDTO);
			
		}catch(OurException e) {
			response.setStatusCode(400);
			response.setMessage(e.getMessage());
		}
		catch(Exception e) {
			response.setStatusCode(500);
			response.setMessage("Error occured during User Registration " + e.getMessage());
		}
		return response;
		
	}


	public Response login(LoginRequest loginRequest) {
		
		Response response = new Response();
		
		if(loginRequest.getUsername()==null || loginRequest.getPassword()==null) {
			response.setStatusCode(400);
			response.setMessage("Fill all the details");
			return response;
		}
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
			var user = userRepository.findByEmail(loginRequest.getUsername()).orElseThrow(()->new OurException("User Not Found"));
			
			var token = jwtUtils.generatedToken(user);
			UserDTO userDTO = Utils.mapUserEntityToUserDTO(user);
			
			response.setUser(userDTO);
			response.setStatusCode(200);
			response.setToken(token);
			response.setRole(user.getRole());
			response.setExpirationTime("7 Days");
			response.setMessage("Successful");
		}
		catch(AuthenticationException e) {
			response.setStatusCode(400);
			response.setMessage("Invalid Email/Password");
		}
		catch(OurException e) {
			response.setStatusCode(400);
			response.setMessage(e.getMessage());
		}
		catch(Exception e) {
			response.setStatusCode(500);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}

}
