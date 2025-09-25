import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número positivo:");
        int num = sc.nextInt();
        int total = 0;

        while(num >= 0){
            System.out.println("Escribe otro número positivo:");
            num = sc.nextInt();
            total++;
        }
        System.out.printf("Has introducido %d números positivos",total);
    }
}
