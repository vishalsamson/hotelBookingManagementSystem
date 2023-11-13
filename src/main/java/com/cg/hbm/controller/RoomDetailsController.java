package com.cg.hbm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.cg.hbm.dto.RoomDetailsDTO;
import com.cg.hbm.payload.ApiResponse;
import com.cg.hbm.service.IFileService;
import com.cg.hbm.service.IRoomDetailsService;

@RestController
@RequestMapping("/api/roomdetails")
public class RoomDetailsController {

	@Autowired
	IRoomDetailsService roomDetailsService;

	@Autowired
	IFileService fileService;
	
	@Value("${project.image}")
	private String path;

	@PostMapping("/add/{hotelId}")
	public ResponseEntity<RoomDetailsDTO> createRoomDetails(@RequestBody RoomDetailsDTO roomDetailsDTO,
			@PathVariable int hotelId) {
		RoomDetailsDTO savedRoomDetailsDTO = roomDetailsService.createRoomDetails(roomDetailsDTO, hotelId);
		return new ResponseEntity<RoomDetailsDTO>(savedRoomDetailsDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{roomId}")
	public ResponseEntity<RoomDetailsDTO> updateRoomDetails(@RequestBody RoomDetailsDTO roomDetailsDTO,
			@PathVariable int roomId) {
		RoomDetailsDTO savedRoomDetailsDTO = roomDetailsService.updateRoomDetails(roomDetailsDTO, roomId);
		return new ResponseEntity<RoomDetailsDTO>(savedRoomDetailsDTO, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{roomId}")
	public ResponseEntity<ApiResponse> deleteRoomDetails(@PathVariable int roomId) {
		roomDetailsService.deleteRoomDetails(roomId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully", true), HttpStatus.OK);

	}

	@GetMapping("/{roomId}")
	public ResponseEntity<RoomDetailsDTO> getRoomDetailsById(@PathVariable int roomId) {
		RoomDetailsDTO savedRoomDetailsDTO = roomDetailsService.getRoomDetailsById(roomId);
		return new ResponseEntity<RoomDetailsDTO>(savedRoomDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<RoomDetailsDTO>> getAllRoomDetails() {
		List<RoomDetailsDTO> allRoomDetailsDTO = roomDetailsService.getAllRoomDetails();
		return new ResponseEntity<List<RoomDetailsDTO>>(allRoomDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/roomsinhotel/{hotelId}")
	public ResponseEntity<List<RoomDetailsDTO>> getRoomsInHotel(@PathVariable int hotelId) {
		List<RoomDetailsDTO> allRoomDetailsDTO = roomDetailsService.getRoomsInHotel(hotelId);
		return new ResponseEntity<List<RoomDetailsDTO>>(allRoomDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/availablerooms/{hotelId}")
	public ResponseEntity<List<RoomDetailsDTO>> getAvailableRoomsInHotel(@PathVariable int hotelId) {
		List<RoomDetailsDTO> allRoomDetailsDTO = roomDetailsService.getAvailableRoomsInHotel(hotelId);
		return new ResponseEntity<List<RoomDetailsDTO>>(allRoomDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/roomtype/{hotelId}")
	public ResponseEntity<List<RoomDetailsDTO>> getRoomsByTypeInHotel(@PathVariable int hotelId,
			@RequestParam String roomType) {
		List<RoomDetailsDTO> allRoomDetailsDTO = roomDetailsService.getRoomsByTypeInHotel(hotelId, roomType);
		return new ResponseEntity<List<RoomDetailsDTO>>(allRoomDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/availableroomsbytype")
	public ResponseEntity<List<RoomDetailsDTO>> getRoomsByAvailabilityAndType(@RequestParam boolean isAvailable,
			@RequestParam String roomType) {
		List<RoomDetailsDTO> allRoomDetailsDTO = roomDetailsService.getRoomsByAvailabilityAndType(isAvailable,
				roomType);
		return new ResponseEntity<List<RoomDetailsDTO>>(allRoomDetailsDTO, HttpStatus.OK);
	}

	@GetMapping("/roomsbyprice")
	public ResponseEntity<List<RoomDetailsDTO>> getRoomsByPriceRange(@RequestParam double minRate,
			@RequestParam double maxRate) {
		List<RoomDetailsDTO> allRoomDetailsDTO = roomDetailsService.getRoomsByPriceRange(minRate, maxRate);
		return new ResponseEntity<List<RoomDetailsDTO>>(allRoomDetailsDTO, HttpStatus.OK);
	}
	
	@PostMapping("/room/image/upload/{roomId}")
	public ResponseEntity<RoomDetailsDTO> uploadPostImage(@RequestParam("image") MultipartFile image, @PathVariable int roomId)
			throws IOException {

		RoomDetailsDTO savedRoomDetailsDTO = roomDetailsService.getRoomDetailsById(roomId);
		String fileName = fileService.uploadImage(path, image);

		savedRoomDetailsDTO.setFileName(fileName);
		String[] fileNames=fileName.split("\\.");
		savedRoomDetailsDTO.setFileType(fileNames[fileNames.length-1]);
		RoomDetailsDTO updatedRoomDetailsDTO = roomDetailsService.updateRoomDetails(savedRoomDetailsDTO, roomId);
		return new ResponseEntity<RoomDetailsDTO>(updatedRoomDetailsDTO, HttpStatus.OK);

	}
	
	@GetMapping(value="/images/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName,HttpServletResponse response ) throws IOException {
		InputStream resource= fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
	
	
}
