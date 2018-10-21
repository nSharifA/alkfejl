package com.alkfejl.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkfejl.cinema.model.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
