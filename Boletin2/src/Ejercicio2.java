import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una número base");
        int base = sc.nextInt();
        System.out.println("Introduce una número exponente");
        int exponente = sc.nextInt();
        int resultado = 1;
       if (base < 0 || exponente < 0) {
           System.out.println("Datos icorrectos, introduzca números mayores a 0");
           base = sc.nextInt();
           exponente = sc.nextInt();
       }
       for (int i = 0; i < exponente; i++) {
            resultado *= base;
       }
        System.out.println("El cálculo exponecial es "+resultado);

    }
}
