package com.example.demo.Repository;

import com.example.demo.Entity.pelicula_2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pelicula_2Repository extends JpaRepository<pelicula_2Entity, Integer> {
}
