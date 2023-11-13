package com.cg.hbm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.UserDTO;
import com.cg.hbm.payload.ApiResponse;
import com.cg.hbm.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO user = userService.addUser(userDto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
//-------------------------------------------------------------------------------------------------------------
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable int id) {
		UserDTO updatedUser = userService.updateUser(userDto, id);
		return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
	}
//-------------------------------------------------------------------------------------------------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id) {
		userService.removeUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("deleted successfully", true),HttpStatus.OK);
	}
//-------------------------------------------------------------------------------------------------------------
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
		UserDTO userDto = userService.getUserById(id);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
//-------------------------------------------------------------------------------------------------------------
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> savedUsers=userService.getAllUsers();
		return ResponseEntity.ok(savedUsers);
	}
//-------------------------------------------------------------------------------------------------------------	
	
}