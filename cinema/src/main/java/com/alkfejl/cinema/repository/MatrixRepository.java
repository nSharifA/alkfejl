package com.alkfejl.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkfejl.cinema.model.Matrix;
@Repository
public interface MatrixRepository extends JpaRepository<Matrix, Long> {

}
