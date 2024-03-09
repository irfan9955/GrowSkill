package com.growskill.service;

import java.util.List;

import com.growskill.entity.User;
import com.growskill.exceptoin.UserException;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getUserById(Long id) throws UserException;
	
	public User createUser(User user);
	
	public User updateUser(Long id,User user) throws UserException;
	
	public boolean deleteUser(Long id) throws UserException;
	
}
