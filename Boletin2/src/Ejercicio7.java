import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        do {
            System.out.print("Ingrese el primer número entero (> 0): ");
            num1 = scanner.nextInt();
        } while (num1 <= 0);

        do {
            System.out.print("Ingrese el segundo número entero (> 0): ");
            num2 = scanner.nextInt();
        } while (num2 <= 0);

        int mcd = calcularMCD(num1, num2);

        System.out.println("El máximo común divisor de " + num1 + " y " + num2 + " es: " + mcd);

        scanner.close();
    }
    public static int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

