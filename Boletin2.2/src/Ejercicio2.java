import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int numero, invertido = 0, resto;
        Scanner consola = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        numero = consola.nextInt();

        while (numero > 0) {
            resto = numero % 10;
            invertido = invertido * 10 + resto;
            numero /= 10;
            }
            if(invertido==numero){
                System.out.println("Tú número es capicúa");
            }
            else {
                System.out.println("El número no es capucúa");
            }
        }
    }
