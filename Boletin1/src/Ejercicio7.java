import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números quieres introduccir?");
        int n1 = sc.nextInt();
        double suma = 0;
        int n2 = 0;

        while (n1 <= 0) {
            System.out.println("Error, itroduzca una cantida mayor a esa,¿Cuántos números quieres introduccir?");
            n1 = sc.nextInt();
        }
        for (int i = 0; i < n1; i++) {
            System.out.println("escrba sus números");
            n2 = sc.nextInt();
            suma += n2;
        }
        double media = suma / n1;
        System.out.printf("La media de sus números es " + media);
    }
}
