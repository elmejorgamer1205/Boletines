import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        //Creo un Scanner para preguntar al usuario los números que quiere sumar
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba los números que quiere sumar:");
        //Creo las variables a para el primer número y la variable b para el segundo número recogido por pantalla
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Creo una variable que sume a y b, y guarde el resultado
        int suma = a + b;
        //Imprimo por pantalla el resultado de la suma
        System.out.println("La suma de "+a+" con "+b+" es: "+suma);
    }
}
