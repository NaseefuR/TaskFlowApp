package com.task.service.interfac;

import com.task.dto.LoginRequest;
import com.task.dto.Response;
import com.task.entity.User;

public interface UserService {

	public Response register(User userdetails);
	
	public Response login(LoginRequest loginRequest);
}
