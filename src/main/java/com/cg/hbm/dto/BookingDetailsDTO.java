package com.cg.hbm.dto;

import java.time.LocalDate;
import java.util.List;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.entity.RoomDetails;
import com.cg.hbm.entity.User;

import lombok.Data;

@Data
public class BookingDetailsDTO {
	
	private int id;
	private LocalDate bookedFrom;
	private LocalDate bookedTo;
	private int noOfAdults;
	private int noOfChildren;
	private double amount;
	private User user;
	private Hotel hotel;
	private List<RoomDetails> roomDetailsList;
}
