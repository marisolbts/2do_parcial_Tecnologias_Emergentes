package com.example.demo.Controller;

import com.example.demo.Entity.pelicula_2Entity;
import com.example.demo.Service.Pelicula_2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas2")
public class Pelicula_2Controller {

	@Autowired
	private Pelicula_2Service pelicula2Service;

	// Obtener todas las películas
	@GetMapping
	public List<pelicula_2Entity> obtenerTodas() {
		return pelicula2Service.obtenerTodas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<pelicula_2Entity> obtenerPorId(@PathVariable Integer id) {
		return pelicula2Service.obtenerPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	public pelicula_2Entity guardar(@RequestBody pelicula_2Entity pelicula) {
		return pelicula2Service.guardar(pelicula);
	}


	@PutMapping("/{id}")
	public ResponseEntity<pelicula_2Entity> actualizar(@PathVariable Integer id, @RequestBody pelicula_2Entity datosActualizados) {
		try {
			pelicula_2Entity peliculaActualizada = pelicula2Service.actualizar(id, datosActualizados);
			return ResponseEntity.ok(peliculaActualizada);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		pelicula2Service.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
