package com.alkfejl.cinema.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.alkfejl.cinema.model.Element;
import com.alkfejl.cinema.model.Matrix;
import com.alkfejl.cinema.model.Room;
import com.alkfejl.cinema.repository.ElementRepository;
import com.alkfejl.cinema.repository.MatrixRepository;

@Service
public class MatrixService {
	private final MatrixRepository matrixRepository;
	private final ElementRepository elementRepository;
	public MatrixService(MatrixRepository matrixRepository, ElementRepository elementRepository) {
		super();
		this.matrixRepository = matrixRepository;
		this.elementRepository = elementRepository;
	}
	
	public Matrix getMatrixById(Long id) {
		return matrixRepository.findById(id).get();
	}
	@Transactional
	public Matrix savedMatrix(Room savedRoom,Matrix matrix) {
		Matrix newMatrix = new Matrix();
		Matrix savedMatrix = matrixRepository.save(newMatrix);
		List<Element> elements = new ArrayList<>();
		for(int i=0;i<matrix.getElements().size();i++) {
			Element newElement = new Element();
			Element savedElement=elementRepository.save(newElement);
			savedElement.setMatrix(savedMatrix);
			savedElement.setRow(matrix.getElements().get(i).getRow());
			savedElement.setColumns(matrix.getElements().get(i).getColumns());
			savedElement.setState(matrix.getElements().get(i).getState());
			savedElement=elementRepository.save(newElement);
			elements.add(savedElement);
		}
		savedMatrix.setRoom(savedRoom);
		savedMatrix.setElements(elements);
		savedMatrix = matrixRepository.save(savedMatrix);
		return savedMatrix;
	}
}
