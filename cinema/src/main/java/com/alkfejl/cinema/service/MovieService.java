package com.alkfejl.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.alkfejl.cinema.model.Movie;
import com.alkfejl.cinema.repository.MovieRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}
	
	
	public List<Movie> getAllMovie(){
		return movieRepository.findAll();
	}
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).get();
	}
	
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
	
	public Movie updateMovie(Movie movie) {
		Optional<Movie> updatingMovie = movieRepository.findById(movie.getId());
		if(updatingMovie.isPresent()) {
			updatingMovie.get().setName(movie.getName());
			 movieRepository.save(updatingMovie.get());
		}else {
			
			return null;
		}
		return updatingMovie.get();
	}
}
