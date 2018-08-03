package com.pabs.test.service;

import java.util.List;

import com.pabs.test.model.User;

public interface UserService {
	public User createUser(User user);
	public User editUser(User user);
	public void deleteUser(Long userId);
	public List<User> getAllUsers();
	public User retrieveUser(String username);
}
