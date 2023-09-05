package com.example.tp1.tp1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubro implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String denominacion;

        // Relación unidireccional: un rubro puede tener varios productos
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "rubro_id") // Nombre de la columna de clave externa en la tabla de Producto
        private List<Producto> productos;

        // Constructor, getters y setters
}

