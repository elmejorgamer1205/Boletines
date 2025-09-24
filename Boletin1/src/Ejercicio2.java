import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero cualquiera");
        int num = sc.nextInt();
        while (num < 0 || num > 10) {
            System.out.println("Numero no valido");
            num = sc.nextInt();
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(num + "*" + i + "=" + num * i);
        }


    }
}
