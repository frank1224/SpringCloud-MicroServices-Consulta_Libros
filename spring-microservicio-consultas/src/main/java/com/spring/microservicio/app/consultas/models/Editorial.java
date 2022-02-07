package com.spring.microservicio.app.consultas.models;

import java.io.Serializable;


public class Editorial implements Serializable{

	private static final long serialVersionUID = -7302790063291752114L;
	
	private Long id;
	private String name;


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
}
