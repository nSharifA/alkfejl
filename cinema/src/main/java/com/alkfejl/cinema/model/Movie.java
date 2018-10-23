package com.alkfejl.cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String name;
	
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="projection_id", nullable = true)
	private Projection projectionOf;
}
