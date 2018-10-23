package com.alkfejl.cinema.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.alkfejl.cinema.model.Matrix;
import com.alkfejl.cinema.model.Room;
import com.alkfejl.cinema.repository.MatrixRepository;
import com.alkfejl.cinema.repository.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository roomRepository;
	private final MatrixRepository matrixRepository;
	private final MatrixService matrixService;

	

	public RoomService(RoomRepository roomRepository, MatrixRepository matrixRepository, MatrixService matrixService) {
		super();
		this.roomRepository = roomRepository;
		this.matrixRepository = matrixRepository;
		this.matrixService = matrixService;
	}

	public List<Room> getAllRoom () {
		return roomRepository.findAll();
	}

	public Room getRoomById ( Long id ) {
		return roomRepository.findById(id).get();
	}

	public void deleteRoom ( Long id ) {
		roomRepository.deleteById(id);
	}
	@Transactional
	public Room createRoom ( Room room ) {
		Room newRoom = new Room();
		Room savedRoom = roomRepository.save(newRoom);
		Matrix savedMatrix = matrixService.savedMatrix(savedRoom, room.getMatrix());
		savedRoom.setNumber(room.getNumber());
		savedRoom.setMatrix(savedMatrix);
		savedRoom.setProjection(room.getProjection());
		return roomRepository.save(savedRoom);
	}

	public Room updateRoom ( Room room ) {
		Optional<Room> updatingRoom = roomRepository.findById(room.getId());
		if(updatingRoom.isPresent()) {
			if(!Objects.equals(updatingRoom.get().getNumber(), room.getNumber())) {
				updatingRoom.get().setNumber(room.getNumber());
			}
			if(!Objects.equals(updatingRoom.get().getMatrix().getId(), room.getMatrix().getId())) {
				
				if(Objects.equals(room.getMatrix().getId(),null)) {
					Matrix savedMatrix = matrixService.savedMatrix(updatingRoom.get(), room.getMatrix());
					updatingRoom.get().setMatrix(savedMatrix);
					roomRepository.save(updatingRoom.get());
				}else {
					updatingRoom.get().setMatrix(room.getMatrix());
					roomRepository.save(updatingRoom.get());
				}
			}
			if(!Objects.equals(updatingRoom.get().getProjection(), room.getProjection())) {
				if(!Objects.equals(room.getProjection(),null)) {
					updatingRoom.get().setProjection(room.getProjection());
				}
			}
		}else{
			return null;
		}
		
		return updatingRoom.get();
		
	}
}
