package com.example.tp1.tp1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.SQLOutput;
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
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "cliente_id")
        private List<Pedido> pedidos;

        public void mostrarPedidos() {
                if (pedidos != null && !pedidos.isEmpty()) {
                        System.out.println("Pedidos de " + nombre + " " + apellido + ":");
                        for (Pedido pedido : pedidos) {
                                System.out.println("Pedido #" + pedido.getId());
                                System.out.println("Fecha: " + pedido.getFecha());
                                System.out.println("Hora estimada de entrega: " + pedido.getHoraEstimadaEntrega());
                                System.out.println("Estado: " + pedido.getEstado());
                                System.out.println("Tipo de envío: " + pedido.getTipoEnvio());
                                System.out.println("Total: " + pedido.getTotal());
                                // Puedes mostrar más detalles del pedido si es necesario
                                System.out.println("----------------------------------------");
                        }
                } else {
                        System.out.println(nombre + " " + apellido + " no tiene pedidos.");
                }
        }
}
