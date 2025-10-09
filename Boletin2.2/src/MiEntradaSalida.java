import java.sql.SQLOutput;
import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero mostrando el mensaje pasado como parámetro
     *
     * @param mensaje El mensaje a mostrar
     * @return el entero leído por teclado
     */

    public static int leerEntero(String mensaje) {
        System.out.println("Introduce un número: ");
        return sc.nextInt();
    }

    public static int leerEnteroPositivo(String mensaje) {
        System.out.println(mensaje);
        int a = sc.nextInt();
        while(a <= 0){
            System.out.println("El número tiene que ser positivo");
            a = sc.nextInt();
        }
        return a;
    }

    public static void main (String[]args){
        int a = MiEntradaSalida.leerEnteroPositivo( "Introduce un número");
        System.out.printf("El primer número introducido es %d", a);
    }
    public static int leerEnteroDeRango(String mensaje, int min, int max) {
        if (min > max) {
        //mostrar mensaje de error
        System.out.println("El mínimo es mayor que el máximo");
        //TODO: cambiar esto al ver las excepciones
        return -1;
        }

        int num = leerEntero(mensaje);

        while (num < min || num > max) {
            System.out.printf("El número está fuera del rango %d-%d", min, max);
            num = leerEntero(mensaje);
        }
        return num;
    }
}