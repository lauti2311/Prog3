package com.example.tp1.tp1.repositorios;

import com.example.tp1.tp1.entidades.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionGeneralRepository extends JpaRepository<ConfiguracionGeneral, Long> {
}
