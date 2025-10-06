import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        do {
            System.out.print("Introduce el primer número (positivo): ");
            n1 = sc.nextInt();
        } while (n1 <= 0);
        do {
            System.out.print("Introduce el segundo número (positivo): ");
            n2 = sc.nextInt();
        } while (n2 <= 0);
        int mcd = calcularMCD(n1, n2);
        System.out.println("El M.C.D. de " + n1 + " y " + n2 + " es " + mcd);
        sc.close();
    }
    public static int calcularMCD(int a, int b) {
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }
}
