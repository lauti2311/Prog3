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
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String numero;
    private String localidad;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id") // Nombre de la columna de clave externa en la tabla de Pedido
    private List<Pedido> pedidos;

    // Relación unidireccional: un domicilio está asociado a un cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id") // Nombre de la columna de clave externa en la tabla de Cliente
    private Cliente cliente;
}
