package com.example.dummy.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona extends BaseEntidad {
    @Column(name = "nombre")
    private String nombre;
    private String apellido;
    private int edad;

}
