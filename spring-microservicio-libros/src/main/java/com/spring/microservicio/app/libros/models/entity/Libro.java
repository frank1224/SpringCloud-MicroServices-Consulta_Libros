package com.spring.microservicio.app.libros.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "libros")
@Entity
public class Libro implements Serializable {

	private static final long serialVersionUID = 8199524346880580506L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	private Double price;
	//@Transient
	//private Integer port;
	
	@JoinTable(name="libros_to_editoriales", joinColumns = @JoinColumn(name="libros_id"),
			inverseJoinColumns = @JoinColumn(name="editoriales_id"),
			uniqueConstraints = {@UniqueConstraint(columnNames = {"libros_id", "editoriales_id"})})
	@ManyToMany(fetch = FetchType.LAZY)
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
