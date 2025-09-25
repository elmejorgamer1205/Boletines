import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número positivo:");
        int num = sc.nextInt();
        int suma = 0;

        while(num < 0){
            System.out.println("El número no es valido, pon uno positivo");
            num = sc.nextInt();
        }
        for (int i = 1; i <= num ; i++) {
           suma = suma +i;
        }
        System.out.println("La suma de todos los número que hay hasta "+ num +" es "+suma);
    }
}
