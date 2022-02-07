package com.spring.microservicio.app.consultas.services;

import java.util.List;


import com.spring.microservicio.app.consultas.models.Consulta;
import com.spring.microservicio.app.consultas.models.Editorial;
import com.spring.microservicio.app.consultas.models.Libro;


public interface IConsultaService {
	
	public List<Consulta> findAll();
	public Consulta findById(Long id);
	public Libro save(Libro libro);
	public Libro update(Libro libro, Long id);
	public void deleteById(Long id);
	

}
