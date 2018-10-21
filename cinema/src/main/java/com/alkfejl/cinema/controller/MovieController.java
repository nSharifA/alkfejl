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

import com.alkfejl.cinema.model.Movie;
import com.alkfejl.cinema.service.MovieService;
@RequestMapping("cinema/movie")
@RestController
public class MovieController {
	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	
	@GetMapping("")
	public List<Movie> getAllMovie(){
		return  movieService.getAllMovie();
	}
	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable Long id) {
		return  movieService.getMovieById(id);
	}
	@PostMapping("")
	public Movie createMovie(@RequestBody Movie movie) {
		return  movieService.createMovie(movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id) {
		 movieService.deleteMovie(id);
	}
	@PutMapping("")
	public Movie updatingMovie(@RequestBody Movie movie) {
		return  movieService.updateMovie(movie);
	}
}
