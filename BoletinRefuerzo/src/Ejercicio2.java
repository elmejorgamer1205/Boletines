import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Creo un escaner para preguntar al usuario el número binario que quiere hacer la conversión
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su número binario: ");
        //Creo una variable para recoger el numero binario del usuario
        int numBinario = sc.nextInt();
        //Creo la variable numDecimal para recoger el resultado de hacer la conversión
        int numDecimal = 0;
        //Creo un bucle While ya que como no sé cuantas veces puede llegar el usuario a fallar
        //Creado una vez el bucle, le digo que si los números son mayores que 1 o menores que 0 le mande un mensaje diciendo que solo se puede poner los números 0 y 1
        while (numBinario < 0 || numBinario > 1) {
            System.out.println("introduce solo los números 1 y 0 para la conversión");
            numBinario = sc.nextInt();
        }
        //Creo un bucle For porque como el número ya esta establecido por el usario y no lo puede cambiar puedo recorrer una por una cada sección de ese número para hacer el cálculo
        for (int i = 0; i < numBinario; i++) {
            numDecimal= numBinario*10;
            System.out.println("Tú número binario sería: "+numDecimal);
        }
    }
}

