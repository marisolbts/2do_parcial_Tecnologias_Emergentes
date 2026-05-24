package com.example.demo.Service;

import com.example.demo.Entity.pelicula_2Entity;
import com.example.demo.Repository.Pelicula_2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pelicula_2Service {

	@Autowired
	private Pelicula_2Repository pelicula2Repository;


	public List<pelicula_2Entity> obtenerTodas() {
		return pelicula2Repository.findAll();
	}

	public Optional<pelicula_2Entity> obtenerPorId(Integer id) {
		return pelicula2Repository.findById(id);
	}


	public pelicula_2Entity guardar(pelicula_2Entity pelicula) {
		return pelicula2Repository.save(pelicula);
	}


	public pelicula_2Entity actualizar(Integer id, pelicula_2Entity datosActualizados) {
		return pelicula2Repository.findById(id).map(pelicula -> {
			pelicula.setTitulo(datosActualizados.getTitulo());
			pelicula.setDuracion(datosActualizados.getDuracion());
			pelicula.setGenero(datosActualizados.getGenero());
			return pelicula2Repository.save(pelicula);
		}).orElseThrow(() -> new RuntimeException("Película no encontrada con el id: " + id));
	}


	public void eliminar(Integer id) {
		pelicula2Repository.deleteById(id);
	}
}
