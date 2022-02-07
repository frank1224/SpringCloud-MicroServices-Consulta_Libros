package com.spring.microservicio.app.libros.controllers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservicio.app.libros.models.entity.Libro;
//import com.spring.microservicio.app.commons.models.entity.Libro;
import com.spring.microservicio.app.libros.models.services.ILibroService;

@RestController
public class LibroController {
	
	@Qualifier("LibroService")
	@Autowired
	private ILibroService libroService;
	
	@GetMapping("/listar")
	public List<Libro>listar(){
		
		return libroService.findAll();

	}
	
	@GetMapping("/ver/{id}")
	public Libro detalle(@PathVariable (value = "id") Long id)throws InterruptedException{
		/*
		if(id.equals(10L)) {
			throw new IllegalStateException("Libro no encontrado!!!");
		}
		if (id.equals(7L)) {
			TimeUnit.SECONDS.sleep(5L); 
		}
		*/
		
		return libroService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/crear")
	public Libro crear(@RequestBody Libro libro) {
		
		return libroService.save(libro);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/editar/{id}")
	public Libro editar(@RequestBody Libro libro, @PathVariable (value = "id") Long id) {
		Libro librosESP = libroService.findById(id);
		librosESP.setId(libro.getId());
		librosESP.setName(libro.getName());
		
		return libroService.save(librosESP);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable (value = "id") Long id) {
		
		libroService.deleteById(id);
	}
	
}
