package com.cg.hbm.controller;

import java.util.List;

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

import com.cg.hbm.dto.BookingDetailsDTO;
import com.cg.hbm.payload.ApiResponse;
import com.cg.hbm.service.IBookingDetailsService;

@RestController
@RequestMapping("/api/bookings/")
public class BookingDetailsController {
	
	@Autowired
	IBookingDetailsService bookingDetailsService;
	
	@PostMapping("/user/{userId}/hotel/{hotelId}")
	public ResponseEntity<BookingDetailsDTO> createBookingDetails(@RequestBody BookingDetailsDTO bookingDetailsDTO,
			@PathVariable int userId,@PathVariable int hotelId){
		BookingDetailsDTO bookingDto=bookingDetailsService.createBookingDetails(bookingDetailsDTO, userId, hotelId);
		return new ResponseEntity<BookingDetailsDTO>(bookingDto,HttpStatus.CREATED);
		
	}
//---------------------------------------------------------------------------------------------------------------------
	@PutMapping("/{bookingId}")
	public ResponseEntity<BookingDetailsDTO> updateBookingDetails(@RequestBody BookingDetailsDTO bookingDetailsDTO,
			@PathVariable int bookingId){
		BookingDetailsDTO bookingDto=bookingDetailsService.updateBookingDetails(bookingDetailsDTO,bookingId);
		return new ResponseEntity<BookingDetailsDTO>(bookingDto,HttpStatus.ACCEPTED);
		
	}
//---------------------------------------------------------------------------------------------------------------------	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<ApiResponse> deleteBookingDetails(@PathVariable int bookingId){
		bookingDetailsService.deleteBookingDetails(bookingId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully", true),HttpStatus.OK);
		
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingDetailsDTO> getBookingDetailsById(@PathVariable int bookingId){
		BookingDetailsDTO bookingDetailsDTO=bookingDetailsService.getBookingDetailsById(bookingId);
		return new ResponseEntity<BookingDetailsDTO>(bookingDetailsDTO,HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/")
	public ResponseEntity<List<BookingDetailsDTO>> getAllBookingDetails(){
		List<BookingDetailsDTO> allBookingDetailsDTOs=bookingDetailsService.getAllBookingDetails();
		return new ResponseEntity<List<BookingDetailsDTO>>(allBookingDetailsDTOs,HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<BookingDetailsDTO>> getBookingsForUser(@PathVariable int userId){
		List<BookingDetailsDTO> allBookingDetailsDTOs=bookingDetailsService.getBookingsForUser(userId);
		return new ResponseEntity<List<BookingDetailsDTO>>(allBookingDetailsDTOs,HttpStatus.OK);	
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<BookingDetailsDTO>> getBookingsForHotel(@PathVariable int hotelId){
		List<BookingDetailsDTO> allBookingDetailsDTOs=bookingDetailsService.getBookingsForHotel(hotelId);
		return new ResponseEntity<List<BookingDetailsDTO>>(allBookingDetailsDTOs,HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/sortbyamount")
	public ResponseEntity<List<BookingDetailsDTO>> getAllBookingDetailsSortedByAmount(){
		List<BookingDetailsDTO> allBookingDetailsDTOs=bookingDetailsService.getAllBookingDetailsSortedByAmount();
		return new ResponseEntity<List<BookingDetailsDTO>>(allBookingDetailsDTOs,HttpStatus.OK);
	}

}
