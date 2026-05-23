package com.example.demo.Controller;

import com.example.demo.Entity.PeliculaEntity;
import com.example.demo.Service.PeliculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
@Tag(name = "Peliculas API", description = "CRUD de la tabla Peliculas")
public class PeliculaController {

    private final PeliculaService service;


    public PeliculaController(PeliculaService service) {
        this.service = service;
    }


    @Operation(summary = "Listar Películas", description = "Obtiene todas las películas registradas")
    @GetMapping
    public List<PeliculaEntity> obtenerPeliculas() {
        return service.listarTodos();
    }

    @Operation(summary = "Obtener Película", description = "Busca una película usando su identificador 'id'")
    @GetMapping("/{id}")
    public Optional<PeliculaEntity> obtenerPelicula(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }


    @Operation(summary = "Registrar nuevas Películas", description = "Agrega una nueva película al sistema. El id es autogenerado, no lo envíes")
    @PostMapping
    public PeliculaEntity agregarPelicula(@RequestBody PeliculaEntity pelicula) {

        pelicula.setId(null);
        return service.registrar(pelicula);
    }

    @Operation(summary = "Actualizar Películas por id", description = "Modifica los campos de una película localizándola por su ID")
    @PutMapping("/{id}")
    public PeliculaEntity actualizarPelicula(@PathVariable Integer id, @RequestBody PeliculaEntity pelicula) {
        return service.actualizar(id, pelicula);
    }


    @Operation(summary = "Eliminar Películas por id", description = "Elimina de forma permanente una película usando su ID")
    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Integer id) {
        service.eliminar(id);
    }
}

