package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.dto.HotelDTO;
import com.cg.hbm.dto.RoomDetailsDTO;

@Service
public interface IHotelService {
	HotelDTO createHotel(HotelDTO hotelDto);
	HotelDTO updateHotel(HotelDTO hotelDto,int hotelId);
	void deleteHotel(int hotelId);
	HotelDTO getHotelById(int hotelId);
	List<HotelDTO> getAllHotels();
	List<HotelDTO> searchHotelsByCity(String city);
	List<HotelDTO> getHotelsByAverageRate(double minRate, double maxRate);
}
