package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.dto.RoomDetailsDTO;

@Service
public interface IRoomDetailsService {
	RoomDetailsDTO createRoomDetails(RoomDetailsDTO roomDetailsDTO,int hotelId);
	RoomDetailsDTO updateRoomDetails(RoomDetailsDTO roomDetailsDTO,int roomId);
	void deleteRoomDetails(int roomId);
	RoomDetailsDTO getRoomDetailsById(int roomId);
	List<RoomDetailsDTO> getAllRoomDetails();
	List<RoomDetailsDTO> getRoomsInHotel(int hotelId);
	List<RoomDetailsDTO> getAvailableRoomsInHotel(int hotelId);
	List<RoomDetailsDTO> getRoomsByTypeInHotel(int hotelId, String roomType);
	List<RoomDetailsDTO> getRoomsByAvailabilityAndType(boolean isAvailable, String roomType);
	List<RoomDetailsDTO> getRoomsByPriceRange(double minRate, double maxRate);

}
