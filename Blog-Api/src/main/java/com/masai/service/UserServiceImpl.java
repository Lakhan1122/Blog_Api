package com.masai.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.UserDto;
import com.masai.exception.ResourceNotFundException;
import com.masai.model.User;
import com.masai.repo.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User saveUser=this.userDao.save(user);
		return this.UserTodto(saveUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user=this.userDao.findById(userId)
				.orElseThrow(()-> new ResourceNotFundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());;
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userDao.save(user);
		UserDto userDto1=this.UserTodto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	
		
		User user=this.userDao.findById(userId)
				.orElseThrow(()->new ResourceNotFundException("User","Id",userId));
		return this.UserTodto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users =this.userDao.findAll();
		
		List<UserDto> userDtos=users.stream().map(user->this.UserTodto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user=this.userDao.findById(userId).orElseThrow(()->new ResourceNotFundException("User","Id",userId));
		
		this.userDao.delete(user);
	}

	
	private User dtoToUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto, User.class);

		 return user;
	}
	
	
	private UserDto UserTodto(User user) {
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		
		 return userDto;
	}
	
	
}
