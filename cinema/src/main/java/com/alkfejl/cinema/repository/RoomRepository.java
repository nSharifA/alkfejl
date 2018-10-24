package com.alkfejl.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkfejl.cinema.model.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
