import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número:");
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Elija otro número mayor que 0");
            num = sc.nextInt();
            if (num % 2 == 0) {
                System.out.println("tu número es par");
            } else if (num % 3 == 0) {
                System.out.println("tu número es divisible entre 3");
            } else {
                System.out.println("tu número es impar");
            }
        }
    }
}

