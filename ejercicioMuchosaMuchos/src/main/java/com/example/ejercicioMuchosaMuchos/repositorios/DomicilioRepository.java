package com.example.ejercicioMuchosaMuchos.repositorios;

import com.example.ejercicioMuchosaMuchos.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
