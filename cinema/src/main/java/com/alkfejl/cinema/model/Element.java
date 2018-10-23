package com.alkfejl.cinema.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Element {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference
	@ManyToOne(targetEntity=Matrix.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "matrix_id")
	private Matrix matrix;

	private Integer row;

	private Integer columns;

	private String state;
}
