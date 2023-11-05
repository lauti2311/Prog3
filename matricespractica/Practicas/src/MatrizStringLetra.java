import java.util.Scanner;
import java.util.HashMap;

public class MatrizStringLetra {
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

        // Imprimir la matriz final
        System.out.println("Matriz final:");
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Buscar letras repetidas en filas horizontales y contar sus repeticiones
        HashMap<Character, Integer> repeticionesHorizontales = new HashMap<>();
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                String oracion = matriz[i][j];
                for (int k = 0; k < oracion.length(); k++) {
                    char letra = oracion.charAt(k);
                    if (repeticionesHorizontales.containsKey(letra)) {
                        repeticionesHorizontales.put(letra, repeticionesHorizontales.get(letra) + 1);
                    } else {
                        repeticionesHorizontales.put(letra, 1);
                    }
                }
            }
        }

        // Buscar letras repetidas en columnas verticales y contar sus repeticiones
        HashMap<Character, Integer> repeticionesVerticales = new HashMap<>();
        for (int j = 0; j < ncolumnas; j++) {
            for (int i = 0; i < nfilas; i++) {
                String oracion = matriz[i][j];
                for (int k = 0; k < oracion.length(); k++) {
                    char letra = oracion.charAt(k);
                    if (repeticionesVerticales.containsKey(letra)) {
                        repeticionesVerticales.put(letra, repeticionesVerticales.get(letra) + 1);
                    } else {
                        repeticionesVerticales.put(letra, 1);
                    }
                }
            }
        }

        // Buscar letras repetidas en diagonales y contar sus repeticiones
        HashMap<Character, Integer> repeticionesDiagonales = new HashMap<>();
        for (int i = 0; i < nfilas - 1; i++) {
            for (int j = 0; j < ncolumnas - 1; j++) {
                String oracion = matriz[i][j];
                if (i < nfilas - 1 && j < ncolumnas - 1) {
                    String diagonal = matriz[i + 1][j + 1];
                    for (int k = 0; k < oracion.length() && k < diagonal.length(); k++) {
                        char letra = oracion.charAt(k);
                        char letraDiagonal = diagonal.charAt(k);
                        if (letra == letraDiagonal) {
                            if (repeticionesDiagonales.containsKey(letra)) {
                                repeticionesDiagonales.put(letra, repeticionesDiagonales.get(letra) + 1);
                            } else {
                                repeticionesDiagonales.put(letra, 1);
                            }
                        }
                    }
                }
            }
        }

        // Imprimir resultados de repeticiones de letras
        System.out.println("Letras repetidas en filas horizontales:");
        for (char letra : repeticionesHorizontales.keySet()) {
            int repeticion = repeticionesHorizontales.get(letra);
            System.out.println(letra + " se repite " + repeticion + " veces en filas horizontales.");
        }

        System.out.println("Letras repetidas en columnas verticales:");
        for (char letra : repeticionesVerticales.keySet()) {
            int repeticion = repeticionesVerticales.get(letra);
            System.out.println(letra + " se repite " + repeticion + " veces en columnas verticales.");
        }

        System.out.println("Letras repetidas en diagonales:");
        for (char letra : repeticionesDiagonales.keySet()) {
            int repeticion = repeticionesDiagonales.get(letra);
            System.out.println(letra + " se repite " + repeticion + " veces en diagonales.");
        }
    }
}
