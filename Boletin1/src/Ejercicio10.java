import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Introduce un número entero positivo: ");
            while (!sc.hasNextInt()) {
                System.out.print("Dato incorrecto. Introduce un número entero positivo: ");
                sc.next();
            }
            numero = sc.nextInt();
            if (numero < 0) {
                System.out.println("El número no puede ser negativo.");
            }
        } while (numero < 0);
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
}




