package com.spring.microservicio.app.consultas.models;

public class Consulta {
	
	public Consulta() {}

	public Consulta(Libro libro) {
		this.libro = libro;
	}

	private Libro libro;

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
}
