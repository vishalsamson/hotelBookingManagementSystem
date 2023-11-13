package com.cg.hbm.dto;

import java.util.List;

import com.cg.hbm.entity.RoomDetails;

import lombok.Data;

@Data
public class HotelDTO {
	
	private int hotelId;
	private String city;
	private String hotelName;
	private String address;
	private String description;
	private double averageRatePerDay;
	private String email;
	private String phone1;
	private String phone2;
	private String website;
	private List<RoomDetails> roomDetailsList;
}
