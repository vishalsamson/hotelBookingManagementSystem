package com.cg.hbm.dto;

import com.cg.hbm.entity.Hotel;

import lombok.Data;

@Data
public class RoomDetailsDTO {
	private int roomId;
	private String roomNo;
	private String roomType;
	private double ratePerDay;
	private boolean isavailable;
	private String fileName;
    private String fileType;
    
    private Hotel hotel;
}
