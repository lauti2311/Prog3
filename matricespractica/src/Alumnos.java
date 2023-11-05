import java.util.Scanner;

public class Alumnos {

    public static void main(String[] args) {
        /*
Maria	Ramirez	C
Juan	Perez	B
Ines	Montes	B
Rene	Pacheco	B
Elena	Morales	A
Mario	Dias	C
Sonia	Navarro	A
         */
        String alumnos[][]= new String[7][3];
        Scanner sc = new Scanner(System.in);
        for (int i =0; i<alumnos.length;i++){
            System.out.println("Ingresa los datos del alumno "+ (i+1));
            for (int j=0; j<3;j++){
                alumnos[i][j]=sc.next();

            }
        }
        System.out.println("Que Aula queres ver? ");
        String aula=sc.next();
        aula=aula.toLowerCase();
        for (int i =0; i<alumnos.length;i++){
           if (alumnos[i][2].toLowerCase().equals(aula)){
               System.out.println("");
               for (int j=0;j<3;j++){
                   System.out.println(alumnos[i][j]+ " ");
               }
           }
        }

    }
}
