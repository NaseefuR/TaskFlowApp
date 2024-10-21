package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.task.dto.LoginRequest;
import com.task.dto.Response;
import com.task.entity.User;
import com.task.service.impl.UserServiceImpl;

@EnableWebMvc
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody User user){
		
		Response response = userServiceImpl.register(user);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest){
		Response response = userServiceImpl.login(loginRequest);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
}
