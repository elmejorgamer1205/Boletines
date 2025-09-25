import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero:");
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Elija otro numero mayor que 0");
            num = sc.nextInt();
        }
        if (num % 2 == 0) {
            System.out.println("tu numero es par");
        }
        if (num % 3 == 0) {
            System.out.println("tu numero es impar");
        }
    }
}