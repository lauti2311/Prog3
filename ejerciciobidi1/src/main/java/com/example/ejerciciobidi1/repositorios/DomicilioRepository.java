package com.example.ejerciciobidi1.repositorios;

import com.example.ejerciciobidi1.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio, Long> {
}
