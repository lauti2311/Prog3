import java.util.Scanner;

public class MatrizPractica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el número de filas: ");
        int nfilas = sc.nextInt();
        System.out.println("Ingrese el número de columnas: ");
        int ncolumnas = sc.nextInt();

        MatrizPrac matriz = new MatrizPrac(nfilas, ncolumnas);

        matriz.ingresarMatriz(sc);
        matriz.mostrarMatriz();

        System.out.println("Ingrese la letra que desea buscar en horizontal: ");
        char letraHorizontal = sc.next().toUpperCase().charAt(0);

        System.out.println("Ingrese la letra que desea buscar en vertical: ");
        char letraVertical = sc.next().toUpperCase().charAt(0);

        int cantidadLetrasIgualesHorizontal = matriz.cantidadLetrasIgualesHorizontal(letraHorizontal);
        int cantidadLetrasIgualesVertical = matriz.cantidadLetrasIgualesVertical(letraVertical);

        matriz.mostrarResultadoHorizontal(letraHorizontal, cantidadLetrasIgualesHorizontal);
        matriz.mostrarResultadoVertical(letraVertical, cantidadLetrasIgualesVertical);
    }
}

class MatrizPrac {
    private char[][] matriz;

    public MatrizPrac(int filas, int columnas) {
        matriz = new char[filas][columnas];
    }

    public void ingresarMatriz(Scanner sc) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Ingrese una letra para [" + i + "][" + j + "]: ");
                String input = sc.next();
                matriz[i][j] = input.toUpperCase().charAt(0);
            }
        }
    }

    public void mostrarMatriz() {
        System.out.println("Matriz final:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int cantidadLetrasIgualesHorizontal(char letra) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                if (matriz[i][j] == letra && matriz[i][j - 1] == letra) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int cantidadLetrasIgualesVertical(char letra) {
        int contador = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 1; i < matriz.length; i++) {
                if (matriz[i][j] == letra && matriz[i - 1][j] == letra) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public void mostrarResultadoHorizontal(char letra, int cantidadLetrasIguales) {
        if (cantidadLetrasIguales > 0) {
            System.out.println("Se encontraron " + cantidadLetrasIguales + " letras " + letra + " iguales de forma horizontal.");
        } else {
            System.out.println("No se encontraron letras " + letra + " iguales de forma horizontal.");
        }
    }

    public void mostrarResultadoVertical(char letra, int cantidadLetrasIguales) {
        if (cantidadLetrasIguales > 0) {
            System.out.println("Se encontraron " + cantidadLetrasIguales + " letras " + letra + " iguales de forma vertical.");
        } else {
            System.out.println("No se encontraron letras " + letra + " iguales de forma vertical.");
        }
    }
}
