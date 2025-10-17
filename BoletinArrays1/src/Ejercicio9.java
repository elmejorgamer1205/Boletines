import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número para ver si esta en mi lista");
        int numero = sc.nextInt();
        int pos = posicionArray(numero);
        if(pos == -1){
            System.out.println("El número no esta en mi lista");
        }else {
            System.out.printf("El número esta en mi lista, en la posición %d ", pos );
        }

    }
    public static int posicionArray(int buscar){
        int[] numeros = {1,4,8,10,2,5,7,3,6};

        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == buscar){
                return i;
            }
        }
        return -1;
    }
}
