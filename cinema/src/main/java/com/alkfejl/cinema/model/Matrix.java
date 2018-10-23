package com.alkfejl.cinema.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Matrix {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference
	@OneToOne(targetEntity=Room.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;

	@JsonManagedReference
	@OneToMany(mappedBy = "matrix", cascade = CascadeType.ALL,orphanRemoval=true, fetch = FetchType.LAZY)
	private List<Element> elements;
}
