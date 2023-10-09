package com.facu.calculadora1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();

    @Test
    void suma() {
        int esperado = 5;
        int resultado = calculadora.suma(2,3);
        assertEquals(esperado, resultado);
        System.out.println("Estoy dentro de la suma");

    }

    @Test
    void resta() {
        int esperado = 3;
        int resultado = calculadora.resta(5,2);
        assertEquals(esperado, resultado);
        System.out.println("Estoy dentro de la resta");
    }

    @Test
    void multiplicacion() {
        int esperado = 10;
        int resultado = calculadora.multiplicacion(2,5);
        assertEquals(esperado, resultado);
        System.out.println("Estoy dentro de la multiplicacion");
    }

    @Test
    void divisionValida() {
        double esperado = 2.5;
        double resultado = calculadora.division(5, 2);
        assertEquals(esperado, resultado, 0.001); // Comprueba que el resultado sea aproximadamente 2.5
        System.out.println("Estoy dentro de la división válida");
    }

    @Test
    void divisionPorCero() {
        assertThrows(ArithmeticException.class, () -> calculadora.division(5, 0));
        System.out.println("Estoy dentro de la división por cero");
    }
}