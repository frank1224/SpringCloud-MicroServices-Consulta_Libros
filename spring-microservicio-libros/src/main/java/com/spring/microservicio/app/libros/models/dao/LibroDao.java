package com.spring.microservicio.app.libros.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.microservicio.app.libros.models.entity.Libro;

//import com.spring.microservicio.app.commons.models.entity.Libro;

public interface LibroDao extends CrudRepository<Libro, Long>{

}
