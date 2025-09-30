import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Introduce un número entero positivo: ");
            while (!sc.hasNextInt()) {
                System.out.print("incorrecto. Introduce un número entero positivo: ");
                sc.next();
            }
            numero = sc.nextInt();
            if (numero <= 0) {
                System.out.println("El número debe ser mayor que cero.");
            }
        } while (numero <= 0);
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        if (suma == numero) {
            System.out.println(numero + " es un número perfecto.");
        } else {
            System.out.println(numero + " no es un número perfecto.");
        }
    }
}