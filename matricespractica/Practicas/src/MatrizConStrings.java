import java.util.Scanner;
import java.util.HashMap;

public class MatrizConStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nfilas;
        int ncolumnas;
        System.out.println("Ingrese el número de filas");
        nfilas = sc.nextInt();
        System.out.println("Ingrese el número de columnas");
        ncolumnas = sc.nextInt();

        String[][] matriz = new String[nfilas][ncolumnas];

        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                System.out.println("Ingrese una oración para [" + i + "] [" + j + "] ");
                matriz[i][j] = sc.next().toLowerCase(); // Convertir a minúsculas
            }
        }

        System.out.println("Matriz final:");
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Buscar oraciones iguales en filas horizontales y contar sus repeticiones
        HashMap<String, Integer> repeticionesHorizontales = new HashMap<>();
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas - 1; j++) {
                String oracion = matriz[i][j];
                if (oracion.equals(matriz[i][j + 1])) {
                    if (repeticionesHorizontales.containsKey(oracion)) {
                        repeticionesHorizontales.put(oracion, repeticionesHorizontales.get(oracion) + 1);
                    } else {
                        repeticionesHorizontales.put(oracion, 1);
                    }
                }
            }
        }

        // Buscar oraciones iguales en columnas verticales y contar sus repeticiones
        HashMap<String, Integer> repeticionesVerticales = new HashMap<>();
        for (int j = 0; j < ncolumnas; j++) {
            for (int i = 0; i < nfilas - 1; i++) {
                String oracion = matriz[i][j];
                if (oracion.equals(matriz[i + 1][j])) {
                    if (repeticionesVerticales.containsKey(oracion)) {
                        repeticionesVerticales.put(oracion, repeticionesVerticales.get(oracion) + 1);
                    } else {
                        repeticionesVerticales.put(oracion, 1);
                    }
                }
            }
        }

        // Buscar oraciones iguales en diagonales y contar sus repeticiones
        HashMap<String, Integer> repeticionesDiagonales = new HashMap<>();
        for (int i = 0; i < nfilas - 1; i++) {
            for (int j = 0; j < ncolumnas - 1; j++) {
                String oracion = matriz[i][j];
                if (oracion.equals(matriz[i + 1][j + 1])) {
                    if (repeticionesDiagonales.containsKey(oracion)) {
                        repeticionesDiagonales.put(oracion, repeticionesDiagonales.get(oracion) + 1);
                    } else {
                        repeticionesDiagonales.put(oracion, 1);
                    }
                }
            }
        }

        // Imprimir resultados de repeticiones de oraciones en filas, columnas y diagonales
        System.out.println("Oraciones repetidas en filas horizontales:");
        for (String oracion : repeticionesHorizontales.keySet()) {
            int repeticion = repeticionesHorizontales.get(oracion);
            System.out.println(oracion + " se repite " + repeticion + " veces en filas horizontales.");
        }

        System.out.println("Oraciones repetidas en columnas verticales:");
        for (String oracion : repeticionesVerticales.keySet()) {
            int repeticion = repeticionesVerticales.get(oracion);
            System.out.println(oracion + " se repite " + repeticion + " veces en columnas verticales.");
        }

        System.out.println("Oraciones repetidas en diagonales:");
        for (String oracion : repeticionesDiagonales.keySet()) {
            int repeticion = repeticionesDiagonales.get(oracion);
            System.out.println(oracion + " se repite " + repeticion + " veces en diagonales.");
        }
    }
}
