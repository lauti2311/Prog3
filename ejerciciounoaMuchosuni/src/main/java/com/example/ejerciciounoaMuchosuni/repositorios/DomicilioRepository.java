package com.example.ejerciciounoaMuchosuni.repositorios;

import com.example.ejerciciounoaMuchosuni.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
