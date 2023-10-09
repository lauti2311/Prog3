package com.facu.calculadora1;

public class Calculadora {

    public int suma(int var1, int var2){
        int resultado = var1 + var2;
        return resultado;
    }

    public int resta (int var1, int var2){
        int resultado = var1 - var2;
        return resultado;
    }
    public int multiplicacion (int var1, int var2){
        int resultado = var1 * var2;
        return resultado;
    }
    public double division(int var1, int var2) {
        if (var2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        double resultado = (double) var1 / var2;
        return resultado;
    }
}
