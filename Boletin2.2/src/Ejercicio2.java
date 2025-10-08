import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int numero, invertido = 0, resto;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        numero = sc.nextInt();
        int numerOriginal = numero;

        while (numero > 0) {
            resto = numero % 10;
            invertido = invertido * 10 + resto;
            numero /= 10;
            }
            if(invertido==numerOriginal){
                System.out.println("Tú número es capicúa");
            }
            else {
                System.out.println("El número no es capucúa");
            }
        }
    }
