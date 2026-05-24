package com.example.demo.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "peliculas_2")
public class pelicula_2Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(hidden = true)
	private Integer id;

	private String titulo;
	private int duracion;
	private String genero;

	// Constructor vacío
	public pelicula_2Entity() {
	}

	public pelicula_2Entity(Integer id, String titulo, int duracion, String genero) {
		this.id = id;
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
	}

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
