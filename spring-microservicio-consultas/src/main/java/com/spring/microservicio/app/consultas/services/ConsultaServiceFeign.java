package com.spring.microservicio.app.consultas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservicio.app.consultas.models.Consulta;
import com.spring.microservicio.app.consultas.models.Editorial;
import com.spring.microservicio.app.consultas.models.Libro;
import com.spring.microservicio.app.consultas.models.rest.LibrosRest;

@Service("ConsultaServiceFeign")
public class ConsultaServiceFeign implements IConsultaService{

	public ConsultaServiceFeign() {}
	
	@Autowired
	LibrosRest libroRestF;

	@Override
	public List<Consulta> findAll() {

		return libroRestF.listar().stream().map(l -> new Consulta(l)).collect(Collectors.toList());
	}

	@Override
	public Consulta findById(Long id) {

		return new Consulta(libroRestF.detalle(id));
	}

	@Override
	public Libro save(Libro libro) {

		return libroRestF.crear(libro);
	}

	@Override
	public Libro update(Libro libro, Long id) {
		
		return libroRestF.editar(libro, id);
	}

	@Override
	public void deleteById(Long id) {
		
		libroRestF.eliminar(id);
		
	}

	
}
