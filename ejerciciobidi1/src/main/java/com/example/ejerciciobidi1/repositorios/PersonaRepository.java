package com.example.ejerciciobidi1.repositorios;

import com.example.ejerciciobidi1.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
}
