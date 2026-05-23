package com.example.demo.Service;

import com.example.demo.Entity.PeliculaEntity;
import com.example.demo.Repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaEntity registrar(PeliculaEntity pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<PeliculaEntity> listarTodos() {
        return peliculaRepository.findAll();
    }

    public Optional<PeliculaEntity> buscarPorId(Integer id) {
        return peliculaRepository.findById(id);
    }

    public PeliculaEntity actualizar(Integer id, PeliculaEntity peliculaDetalles) {
        return peliculaRepository.findById(id).map(pelicula -> {
            pelicula.setTitulo(peliculaDetalles.getTitulo());
            pelicula.setDirector(peliculaDetalles.getDirector());
            pelicula.setAno(peliculaDetalles.getAno());
            pelicula.setDuracion(peliculaDetalles.getDuracion());
            pelicula.setGenero(peliculaDetalles.getGenero());
            pelicula.setSinopsis(peliculaDetalles.getSinopsis());
            return peliculaRepository.save(pelicula);
        }).orElseThrow(() -> new RuntimeException("Película no encontrada con ID: " + id));
    }



    public void eliminar(Integer id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede eliminar. Película no encontrada con ID: " + id);
        }

    }

}
