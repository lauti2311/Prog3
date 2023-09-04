package com.example.ejerciciounoaMuchosbidi.repositorios;

import com.example.ejerciciounoaMuchosbidi.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
