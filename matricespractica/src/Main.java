import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matriz[][], filas, columnas;
        filas = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de filas"));
        columnas = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de columnas"));
        matriz = new int[filas][columnas];

        for (int i=0;i<filas;i++){
            for (int j = 0; j<columnas;j++){
                System.out.print("Matriz ["+i+"]["+j+"]: ");
                matriz[i][j] = sc.nextInt();

            }
        }

        System.out.println("\nLa matriz es: ");
        for (int i =0 ;i<filas;i++){ //filas
            for (int j =0; j<columnas; j++){ //columnas
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }

    }


}