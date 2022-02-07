package com.spring.microservicio.app.consultas.models.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.microservicio.app.consultas.models.Editorial;
import com.spring.microservicio.app.consultas.models.Libro;

@FeignClient(name = "service-libros")//, url = "localhost:8001"
public interface LibrosRest {

	@GetMapping("/listar")
	public List<Libro> listar();

	@GetMapping("/ver/{id}")
	public Libro detalle(@PathVariable Long id);

	@PostMapping("/crear")
	public Libro crear(@RequestBody Libro libro);

	@PutMapping("/editar/{id}")
	public Libro editar(@RequestBody Libro libro, @PathVariable Long id);

	@DeleteMapping("/eliminar/{id}")
	public Libro eliminar(@PathVariable Long id);

}
