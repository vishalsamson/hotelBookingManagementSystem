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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.HotelDTO;
import com.cg.hbm.payload.ApiResponse;
import com.cg.hbm.service.IHotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	@Autowired
	IHotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDto){
		HotelDTO savedHotelDto=hotelService.createHotel(hotelDto);
		return new ResponseEntity<HotelDTO>(savedHotelDto,HttpStatus.CREATED);
	}
//---------------------------------------------------------------------------------------------------------------------
	@PutMapping("/{hotelId}")
	public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDto,@PathVariable int hotelId) {
		HotelDTO savedHotelDto=hotelService.updateHotel(hotelDto,hotelId);
		return new ResponseEntity<HotelDTO>(savedHotelDto,HttpStatus.ACCEPTED);
	}
//---------------------------------------------------------------------------------------------------------------------
	@DeleteMapping("/{hotelId}")
	ResponseEntity<ApiResponse> deleteHotel(@PathVariable int hotelId){
		hotelService.deleteHotel(hotelId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully", true),HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/{hotelId}")
	public ResponseEntity<HotelDTO> getHotelById(@PathVariable int hotelId){
		HotelDTO savedHotelDTO=hotelService.getHotelById(hotelId);
		return new ResponseEntity<HotelDTO>(savedHotelDTO,HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/")
	public ResponseEntity<List<HotelDTO>> getAllHotels(){
		List<HotelDTO> allHotels=hotelService.getAllHotels();
		return new ResponseEntity<List<HotelDTO>>(allHotels,HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/searchbycity/{city}")
	public ResponseEntity<List<HotelDTO>> searchHotelsByCity(@PathVariable String city){
		List<HotelDTO> allHotels=hotelService.searchHotelsByCity(city);
		return new ResponseEntity<List<HotelDTO>>(allHotels,HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------
	@GetMapping("/averagerate")
	public ResponseEntity<List<HotelDTO>> getHotelsByAverageRate(@RequestParam double minRate,@RequestParam  double maxRate){
		List<HotelDTO> allHotels=hotelService.getHotelsByAverageRate(minRate,maxRate);
		return new ResponseEntity<List<HotelDTO>>(allHotels,HttpStatus.OK);
	}
//---------------------------------------------------------------------------------------------------------------------		
	
}
