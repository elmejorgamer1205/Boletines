import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        int aleatorio = (int)(Math.random() * 100) + 1;
        Scanner sc = new Scanner(System.in);
        int intentos = 0;
        boolean acertado = false;
        while (intentos < MAX_INTENTOS && !acertado) {
            System.out.println("Elige un número entre el 1 y el 100");
            int a = sc.nextInt();
            if(a > 100 || a <  1){
                System.out.println("Este número no está permitido");
            }else {
                if(aleatorio < a) {
                    System.out.println("El número "+a+" es mayor que el aleatorio");
                }else if (aleatorio > a){
                    System.out.println("El número "+a+" es menor que el aleatorio");
                }else {
                    System.out.println("Has acertado el número oculto "+ aleatorio);
                }
            }
        }


    }
}