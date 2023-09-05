package com.example.tp1.tp1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String fecha;
    private String estado;
    private String horaEstimadaEntrega;
    private String tipoEnvio;
    private double total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detallesPedido;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    private Factura factura;

    @OneToOne(cascade = CascadeType.ALL, optional = true) // Esta es la relación con Domicilio
    private Domicilio domicilio;

    @ManyToOne // Esta es la relación con Cliente
    private Cliente cliente;

    @ManyToOne
    private Usuario usuario;

}