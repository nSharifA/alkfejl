package com.alkfejl.cinema.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.alkfejl.cinema.model.Projection;
import com.alkfejl.cinema.repository.ProjectionRepository;

import lombok.Data;
@Data
@Service
public class ProjectionService {
	private final ProjectionRepository projectionRepository;

	public ProjectionService(ProjectionRepository projectionRepository) {
		super();
		this.projectionRepository = projectionRepository;
	}
	
	public Projection getProjectionById(Long id) {
		return projectionRepository.findById(id).get();
	}
	public List<Projection> getAllProjection(){
		return projectionRepository.findAll();
	}
	public void deleteProjectionById(Long id) {
		projectionRepository.deleteById(id);
	}
	public Projection createProjection(Projection projection) {
		Projection newProjection = new Projection();
		Projection savedProjection = projectionRepository.save(newProjection);
		savedProjection.setMovie(projection.getMovie());
		savedProjection.setRoom(projection.getRoom());
		savedProjection.setStart_time(projection.getStart_time());
		savedProjection.setEnd_time(projection.getEnd_time());
		savedProjection.setUsers(projection.getUsers());
		return projectionRepository.save(savedProjection);
	}
	
	public Projection updateProjection(Projection projection) {
		Projection savedProjection = projectionRepository.findById(projection.getId()).get();
		if(!Objects.equals(savedProjection.getStart_time(), projection.getStart_time())) {
			savedProjection.setStart_time(projection.getStart_time());
		}
		if(!Objects.equals(savedProjection.getEnd_time(), projection.getEnd_time())) {
			savedProjection.setEnd_time(projection.getEnd_time());
		}
		if(!Objects.equals(savedProjection.getUsers().size(), projection.getUsers().size())) {
			savedProjection.setUsers(projection.getUsers());
		}
		if(!Objects.equals(savedProjection.getMovie().getId(), projection.getMovie().getId())) {
			savedProjection.setMovie(projection.getMovie());
		}
		if(!Objects.equals(savedProjection.getRoom().getId(), projection.getRoom().getId())) {
			savedProjection.setRoom(projection.getRoom());
		}
		Projection newProjection = projectionRepository.save(savedProjection);
		return newProjection;
	}
}
