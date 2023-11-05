import java.util.Scanner;

public class BuscarSecuencias {

    public static void main(String[] args) {
        String[][] matriz = {
                {"Esta es una oración de ejemplo.", "Otra oración aquí."},
                {"Tercera oración para probar.", "Última oración."}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la letra que deseas buscar: ");
        String letra = scanner.next();

        contarLetraEnSecuencias(matriz, letra, "oración de ejemplo", "Última oración");
    }

    public static void contarLetraEnSecuencias(String[][] matriz, String letra, String... secuencias) {
        boolean encontrada = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                for (String secuencia : secuencias) {
                    if (matriz[i][j].contains(secuencia)) {
                        int contador = contarLetraEnSecuencia(matriz[i][j], letra);
                        if (contador > 0) {
                            System.out.println("En la fila " + i + ", columna " + j + ": " + contador + " veces encontrada la letra " + letra + " en la secuencia.");
                            encontrada = true;
                        }
                    }
                }
            }
        }

        if (!encontrada) {
            System.out.println("La letra " + letra + " no se encontró en ninguna secuencia.");
        }
    }

    public static int contarLetraEnSecuencia(String oracion, String letra) {
        int contador = 0;
        for (int i = 0; i < oracion.length(); i++) {
            if (String.valueOf(oracion.charAt(i)).equalsIgnoreCase(letra)) {
                contador++;
            }
        }
        return contador;
    }
}