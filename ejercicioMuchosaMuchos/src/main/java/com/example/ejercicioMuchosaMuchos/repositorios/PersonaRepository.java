package com.example.ejercicioMuchosaMuchos.repositorios;
import com.example.ejercicioMuchosaMuchos.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}