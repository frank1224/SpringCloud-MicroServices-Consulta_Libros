package com.spring.microservicio.app.libros.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.microservicio.app.commons.models.entity.Libro;
import com.spring.microservicio.app.libros.models.dao.LibroDao;
import com.spring.microservicio.app.libros.models.entity.Libro;

@Service("LibroService")
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private LibroDao libroDao;

	@Transactional(readOnly = true)
	@Override
	public List<Libro> findAll() {
		
		return (List<Libro>) libroDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Libro findById(Long id) {
		
		return libroDao.findById(id).orElse(null);

	}

	@Transactional
	@Override
	public Libro save(Libro libro) {
		
		return libroDao.save(libro);

	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		
		libroDao.deleteById(id);

	}

}
