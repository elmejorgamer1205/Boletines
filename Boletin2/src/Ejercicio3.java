import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número ");
        int num = sc.nextInt();
        int n1 = num;
        int caracteres = 0;
        do{
            n1 /=10;
            caracteres++;
        }while(Math.abs(n1)>0);
        System.out.println("El número "+num+" tiene "+caracteres+" cifras");
    }
}
