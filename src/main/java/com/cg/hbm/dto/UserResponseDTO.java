package com.cg.hbm.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
	private int id;
	private String username;
	private String email;
	private String password;
	private long mobile;
	private String address;

}
