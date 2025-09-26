import java.util.Scanner;

public class Ejercicio_Do_While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String PASSWORD = "1Dam";
        String entrada;
        do {
            System.out.print("Introduce la contraseña: ");
            entrada = sc.nextLine();
            if (!entrada.equals(PASSWORD)) {
                System.out.println("Contraseña incorrecta. Inténtalo de nuevo.");
            }
        } while (!entrada.equals(PASSWORD));
        System.out.println("Contraseña correcta, bienvenido :)");
        sc.close();
    }
}

