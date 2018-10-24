package com.alkfejl.cinema.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Projection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Timestamp start_time;

	private Timestamp end_time;

	@JsonManagedReference
	@OneToMany(mappedBy = "projection")
	private List<User> users;

	@JsonManagedReference
	@OneToOne(mappedBy = "projectionOf")
	private Movie movie;

	@JsonManagedReference
	@OneToOne(mappedBy = "projection")
	private Room room;
}
