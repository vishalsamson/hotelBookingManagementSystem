package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.dto.UserDTO;

@Service
public interface IUserService {
	UserDTO addUser(UserDTO userDto);
	UserDTO updateUser(UserDTO userDto,int id);
	void removeUser(int id);
	UserDTO getUserById(int userId);
	List<UserDTO> getAllUsers();
}
