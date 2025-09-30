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
        int a = MiEntradaSalida.leerEnteroPositivo("Introduce un número");
        System.out.printf("El primer número introducido es %d", a);
    }
}





