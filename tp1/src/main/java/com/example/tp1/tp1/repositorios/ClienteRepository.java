package com.example.tp1.tp1.repositorios;

import com.example.tp1.tp1.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
