import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba los números que quiere sumar:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int suma = a + b;
        System.out.println("La suma de "+a+" con "+b+" es: "+suma);
    }
}
