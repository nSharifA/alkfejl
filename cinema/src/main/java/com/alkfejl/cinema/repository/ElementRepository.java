package com.alkfejl.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkfejl.cinema.model.Element;
@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {

}
