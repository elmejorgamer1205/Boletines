import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int menor = Integer.MAX_VALUE;
        String respuesta;
        do {
            System.out.print("Introduce un número: ");
            numero = sc.nextInt();
            if (numero < menor) {
                menor = numero;
            }
            do {
                System.out.print("¿Desea introducir más números (S/N)? ");
                respuesta = sc.next().toUpperCase();
            } while (!respuesta.equals("S") && !respuesta.equals("N"));

        } while (respuesta.equals("S"));

        System.out.println("El menor de los números introducidos es: " + menor);
    }
}
