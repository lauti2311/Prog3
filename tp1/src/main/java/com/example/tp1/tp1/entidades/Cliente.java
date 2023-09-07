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
public class Cliente implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String apellido;
        private String telefono;
        private String email;

        //Relacion de Uno a muchos de cliente con Pedido.
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "cliente_id")
        private List<Pedido> pedidos;

}
