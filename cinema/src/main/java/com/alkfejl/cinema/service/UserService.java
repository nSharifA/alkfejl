package com.alkfejl.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alkfejl.cinema.model.User;
import com.alkfejl.cinema.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	public User createUser(User user) {
		return userRepository.save(user);
	}	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	public User updateUser(User user) {
		Optional<User> updatingUser = userRepository.findById(user.getId());
		if( updatingUser.isPresent()) {
			updatingUser.get().setName(user.getName());
			updatingUser.get().setLogin(user.getLogin());
			userRepository.save(updatingUser.get());
		}else {
			User userNotFound = new User();
			return userNotFound;
		}
		return updatingUser.get();
	}
}
