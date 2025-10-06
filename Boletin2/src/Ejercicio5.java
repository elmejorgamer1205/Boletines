import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu número: ");
        int n1 = sc.nextInt();
        boolean esPrimo = true;
        if (n1 <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i <= n1 / 2 && esPrimo; i++) {
                if (n1 % i == 0) {
                    esPrimo = false;
                }
            }
        }
        if (esPrimo) {
            System.out.printf("El número %d es primo%n", n1);
        } else {
            System.out.printf("El número %d no es primo%n", n1);
        }
    }
}


