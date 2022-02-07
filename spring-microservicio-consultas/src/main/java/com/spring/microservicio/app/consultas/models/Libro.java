package com.spring.microservicio.app.consultas.models;

import java.util.List;


public class Libro {

	private Long id;
	private String name;
	private Double price;
	
	private List<Editorial> editoriales;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(List<Editorial> editoriales) {
		this.editoriales = editoriales;
	}
	
	

}
