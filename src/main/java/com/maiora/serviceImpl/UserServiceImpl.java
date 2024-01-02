package com.maiora.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiora.dto.UserRequest;
import com.maiora.entity.User;
import com.maiora.exception.UserNotFoundException;
import com.maiora.repository.UserRepository;
import com.maiora.service.UserService;

@Service

public class UserServiceImpl implements UserService{
	
	
    @Autowired
    private UserRepository repository;


	
	  public User saveUser(UserRequest userRequest) { User user = User.build(0,
	  userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
	  userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
	  return repository.save(user); }
	 
    
	/*
	 * public User saveUser(UserRequest userRequest) { try { User user =
	 * User.build(0, userRequest.getName(), userRequest.getEmail(),
	 * userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),
	 * userRequest.getNationality()); return repository.save(user); } catch
	 * (Exception e) { // Handle the exception or log it, depending on your
	 * requirements e.printStackTrace(); // or log it using a logging framework //
	 * You might want to throw a custom exception or return a special value
	 * indicating failure throw new RuntimeException("Failed to save user: " +
	 * e.getMessage(), e); } }
	 */

    public List<User> getALlUsers() {
        return repository.findAll();
    }


    public User getUser(int id) throws UserNotFoundException {
        User user= repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }
}


