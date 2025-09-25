import java.util.Scanner;

public class Bucle_While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número");
        int num = sc.nextInt();

        int comprobar = 2;

        while (comprobar <= num / 2 && num % comprobar != 0) {
            comprobar++;
        }
        if (num % comprobar == 0) {
            System.out.println("El primo divisor es " + comprobar);
        }else {
            System.out.println("El número es primo " + num);
        }
    }
}
