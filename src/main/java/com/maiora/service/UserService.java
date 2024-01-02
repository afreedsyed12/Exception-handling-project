package com.maiora.service;

import java.util.List;

import com.maiora.dto.UserRequest;
import com.maiora.entity.User;
import com.maiora.exception.UserNotFoundException;



public interface UserService {
	
	public User saveUser(UserRequest userRequest);
	
	  public List<User> getALlUsers();
	  
	  public User getUser(int id) throws UserNotFoundException;

}
