package com.masai.service;

import java.util.List;

import com.masai.DTO.UserDto;

public interface UserService {

	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto>  getAllUsers();
	
	void deleteUser(Integer userId);
	
}
