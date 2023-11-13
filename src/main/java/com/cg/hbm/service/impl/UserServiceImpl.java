package com.cg.hbm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.boot.spi.AdditionalJaxbMappingProducer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.dto.UserDTO;
import com.cg.hbm.entity.User;
import com.cg.hbm.exception.ResourceNotFoundException;
import com.cg.hbm.repository.IUserRepository;
import com.cg.hbm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDTO addUser(UserDTO userDto) {
		User user=modelMapper.map(userDto, User.class);
		User savedUser=userRepository.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, int id) {
		User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
		
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setMobile(userDto.getMobile());
		user.setAddress(userDto.getAddress());
		
		User savedUser=userRepository.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
		
		
	}

	@Override
	public void removeUser(int id) {
		User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
		userRepository.delete(user);
		
	}

	@Override
	public UserDTO getUserById(int userId) {
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users=userRepository.findAll();
		return users.stream().map(user->modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}
	

}
