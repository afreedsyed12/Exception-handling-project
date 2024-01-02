package com.maiora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maiora.dto.UserRequest;
import com.maiora.entity.User;
import com.maiora.exception.UserNotFoundException;
import com.maiora.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
	}

//	@PostMapping("/signup")
//	public ResponseEntity<?> saveUser(@RequestBody @Valid UserRequest userRequest) {
//	    try {
//	        User savedUser = service.saveUser(userRequest),HttpStatus.CREATED;
//	        return  ResponseEntity.ok(savedUser);
//	    } 


//	    
//	    catch (Exception e) {
//	        e.printStackTrace(); 
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                             .body("Failed to save user: " + e.getMessage());
//	    }
	// }

	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(service.getALlUsers());
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
//		return ResponseEntity.ok(service.getUser(id));
//	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		try {
			User ser = service.getUser(id);
			return ResponseEntity.ok(ser);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
