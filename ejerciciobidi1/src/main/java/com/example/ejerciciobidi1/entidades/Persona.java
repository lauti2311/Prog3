package com.example.ejerciciobidi1.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "persona")
public class Persona extends BaseEntidad{
    @Column(name = "nombre")
    private String nombre;
    private String apellido;
    private int edad;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
}
