package com.alkfejl.cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkfejl.cinema.model.User;
import com.alkfejl.cinema.service.UserService;
@RequestMapping("/cinema/user")
@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("getAllUser")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	@DeleteMapping("{id}")
	public void createUser(@PathVariable Long id) {
		 userService.deleteUser(id);
	}
	@PutMapping("")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
}
