package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.dto.BookingDetailsDTO;

@Service
public interface IBookingDetailsService {
	BookingDetailsDTO createBookingDetails(BookingDetailsDTO bookingDetailsDTO,int userId,int hotelId);
	BookingDetailsDTO updateBookingDetails(BookingDetailsDTO bookingDetailsDTO,int bookingId);
	void deleteBookingDetails(int bookingId);
	BookingDetailsDTO getBookingDetailsById(int bookingId);
	List<BookingDetailsDTO> getAllBookingDetails();
	List<BookingDetailsDTO> getBookingsForUser(int userId);
	List<BookingDetailsDTO> getBookingsForHotel(int hotelId);
	public List<BookingDetailsDTO> getAllBookingDetailsSortedByAmount();
}
