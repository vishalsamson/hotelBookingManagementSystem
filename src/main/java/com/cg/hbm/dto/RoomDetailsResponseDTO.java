package com.cg.hbm.dto;

import lombok.Data;

@Data
public class RoomDetailsResponseDTO {
	private int id;
	private String roomNo;
	private String roomType;
	private double ratePerDay;
	private boolean isavailable;
	private String fileName;
    private String fileType;

}
