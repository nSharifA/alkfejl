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

import com.alkfejl.cinema.model.Projection;
import com.alkfejl.cinema.service.ProjectionService;

@RequestMapping("/cinema/projection")
@RestController
public class ProjectionController {

	private final ProjectionService projectionService;

	public ProjectionController(ProjectionService projectionService) {
		super();
		this.projectionService = projectionService;
	}
	@GetMapping("{id}")
	public Projection getProjectionById(@PathVariable Long id) {
		return projectionService.getProjectionById(id);
	}
	@GetMapping("")
	public List<Projection> getAllProjection(){
		return projectionService.getAllProjection();
	}
	@DeleteMapping("{id}")
	public void deleteProjectionById(@PathVariable Long id) {
		projectionService.deleteProjectionById(id);
	}
	@PostMapping("")
	public Projection createProjection(@RequestBody Projection projection) {
		return projectionService.createProjection(projection);
		
	}
	@PutMapping("")
	public Projection updateProjection(@RequestBody Projection projection) {
		return projectionService.updateProjection(projection);
	}
}
