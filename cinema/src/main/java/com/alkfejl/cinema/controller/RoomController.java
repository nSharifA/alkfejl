package com.alkfejl.cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkfejl.cinema.model.Matrix;
import com.alkfejl.cinema.model.Room;
import com.alkfejl.cinema.service.MatrixService;
import com.alkfejl.cinema.service.RoomService;
@RequestMapping("cinema/room")
@RestController
public class RoomController {
	private final RoomService roomService;
	private final MatrixService matrixService;
	
	
	
	public RoomController(RoomService roomService, MatrixService matrixService) {
		super();
		this.roomService = roomService;
		this.matrixService = matrixService;
	}

	@GetMapping("")
	public List<Room> getAllRoom(){
		return roomService.getAllRoom();
	}
	@GetMapping("{id}")
	public Room getRoomById(@PathVariable Long id) {
		return  roomService.getRoomById(id);
	}
	@DeleteMapping("{id}")
	public void deleteRoom(@PathVariable Long id) {
		roomService.deleteRoom(id);
	}
	@PostMapping("")
	public Room createRoom(@RequestBody Room room) {
		return  roomService.createRoom(room);
	}
	@PutMapping("")
	public Room updateRoom(@RequestBody Room room) {
		return  roomService.updateRoom(room);
	}
}
