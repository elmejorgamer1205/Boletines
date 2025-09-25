import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número:");
        int n1 = sc.nextInt();
        System.out.println("Escribe otro número:");
        int n2 = sc.nextInt();

        int producto = 0;

        for (int i = 0; i < n2; i++) {
            producto += n1;
        }
        System.out.println("El producto es: " + producto);
    }
}