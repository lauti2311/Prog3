import java.util.Scanner;
import java.util.HashMap;

public class Matriz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nfilas;
        int ncolumnas;
        System.out.println("Ingrese el numero de filas");

        nfilas = sc.nextInt();
        System.out.println("Ingrese el numero de columnas");
        ncolumnas = sc.nextInt();

        char[][] matriz = new char[nfilas][ncolumnas];

        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                System.out.println("Ingrese una letra para [" + i + "] [" + j + "] ");
                matriz[i][j] = Character.toLowerCase(sc.next().charAt(0));
            }
        }

        System.out.println("Matriz final: ");
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Buscar letras iguales en filas horizontales y contar sus repeticiones
        HashMap<Character, Integer> repeticionesHorizontales = new HashMap<>();
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas - 1; j++) {
                if (matriz[i][j] == matriz[i][j + 1]) {
                    char letra = matriz[i][j];
                    if (repeticionesHorizontales.containsKey(letra)) {
                        repeticionesHorizontales.put(letra, repeticionesHorizontales.get(letra) + 2);
                    } else {
                        repeticionesHorizontales.put(letra, 2);
                    }
                }
            }
        }

        // Buscar letras iguales en columnas verticales y contar sus repeticiones
        HashMap<Character, Integer> repeticionesVerticales = new HashMap<>();
        for (int j = 0; j < ncolumnas; j++) {
            for (int i = 0; i < nfilas - 1; i++) {
                if (matriz[i][j] == matriz[i + 1][j]) {
                    char letra = matriz[i][j];
                    if (repeticionesVerticales.containsKey(letra)) {
                        repeticionesVerticales.put(letra, repeticionesVerticales.get(letra) + 2);
                    } else {
                        repeticionesVerticales.put(letra, 2);
                    }
                }
            }
        }

        // Buscar letras iguales en diagonales y contar sus repeticiones
        HashMap<Character, Integer> repeticionesDiagonales = new HashMap<>();
        for (int i = 0; i < nfilas - 1; i++) {
            for (int j = 0; j < ncolumnas - 1; j++) {
                if (matriz[i][j] == matriz[i + 1][j + 1]) {
                    char letra = matriz[i][j];
                    if (repeticionesDiagonales.containsKey(letra)) {
                        repeticionesDiagonales.put(letra, repeticionesDiagonales.get(letra) + 2);
                    } else {
                        repeticionesDiagonales.put(letra, 2);
                    }
                }
            }
        }

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
