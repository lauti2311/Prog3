package com.example.tp1.tp1.repositorios;

import com.example.tp1.tp1.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
