package com.spring.microservicio.app.libros.models.services;

import java.util.List;

import com.spring.microservicio.app.libros.models.entity.Libro;

//import com.spring.microservicio.app.commons.models.entity.Libro;

public interface ILibroService {
	
	public List<Libro> findAll();

	public Libro findById(Long id);
	
	public Libro save(Libro libro);
	
	public void deleteById(Long id); 
}
